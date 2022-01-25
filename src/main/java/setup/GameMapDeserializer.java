package setup;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.GameMap;
import entities.Room;
import utils.Directions;

import java.io.IOException;
import java.util.*;

public class GameMapDeserializer extends JsonDeserializer<GameMap> {

    @Override
    public GameMap deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectMapper om = new ObjectMapper();

        GameMap map = new GameMap();

        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        JsonNode roomsNode = root.get("rooms");
        List<Room> rooms = new ArrayList<>();
        List<Map<Directions, String>> connections = new ArrayList<>();
        Iterator<JsonNode> i = roomsNode.elements();
        while (i.hasNext()) {
            JsonNode roomNode = i.next();
            rooms.add(om.treeToValue(roomNode, Room.class));
            JsonNode connectionsNode = roomNode.get("connections");
            Map<Directions, String> ref = new HashMap<>();
            if (connectionsNode != null) {
                ref.put(Directions.N, connectionsNode.get("N").asText());
                ref.put(Directions.S, connectionsNode.get("S").asText());
                ref.put(Directions.W, connectionsNode.get("W").asText());
                ref.put(Directions.E, connectionsNode.get("E").asText());
            }

            connections.add(ref);
        }

        for (int j = 0; j < rooms.size(); j++) {
            Room r = rooms.get(j);
            Map<Directions, String> conn = connections.get(j);
            map.addRoom(r);
            map.setN(r,
                    rooms.stream()
                            .filter(rm -> rm.getName().equals(conn.get(Directions.N)))
                            .findFirst().orElse(null)
            );
            map.setS(r,
                    rooms.stream()
                            .filter(rm -> rm.getName().equals(conn.get(Directions.S)))
                            .findFirst().orElse(null)
            );
            map.setE(r,
                    rooms.stream()
                            .filter(rm -> rm.getName().equals(conn.get(Directions.E)))
                            .findFirst().orElse(null)
            );
            map.setW(r,
                    rooms.stream()
                            .filter(rm -> rm.getName().equals(conn.get(Directions.W)))
                            .findFirst().orElse(null)
            );
        }

        return map;
    }
}
