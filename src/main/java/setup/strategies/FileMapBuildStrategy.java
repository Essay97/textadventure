package setup.strategies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.*;
import entities.items.GrabbableItem;
import entities.items.Item;
import entities.items.ItemEffect;
import utils.Directions;

/**
 * @deprecated
 * This strategy takes a <code>.txt</code> file written in a specific format and returns a {@link GameMap}. It will
 * not be further documented since it is highly incomplete and no more maintained in favour of better strategies.
 *
 * @see JsonMapBuildStrategy
 * @see YamlMapBuildStrategy
 */
public class FileMapBuildStrategy implements MapBuildStrategy {

    private final String fileName;

    public FileMapBuildStrategy(String fileName) {
        super();
        this.fileName = fileName;
    }

    @Override
    public GameMap build() {
        File mapFile = new File(fileName);
        FileReader reader;
        GameMap map = null;

        try {
            reader = new FileReader(mapFile);
            BufferedReader br = new BufferedReader(reader);

            List<Room> rooms = new ArrayList<>();
            List<Map<Directions, String>> connections = new ArrayList<>();

            map = new GameMap();
            String name = br.readLine();
            while(name != null) {
                if(name.trim().equals("")) {
                    name = br.readLine();
                }
                String description = br.readLine();
                String N = br.readLine();
                N = extractDestinationName(N);
                String S = br.readLine();
                S = extractDestinationName(S);
                String E = br.readLine();
                E = extractDestinationName(E);
                String W = br.readLine();
                W = extractDestinationName(W);
                Room room = new Room(name, description);
                String itemData = br.readLine();
                while(itemData != null && !itemData.trim().equals("")) {
                    String itemDescr = br.readLine();
                    Item item = parseItemData(itemData, itemDescr);
                    room.addItem(item);
                    itemData = br.readLine();
                }
                rooms.add(room);
                connections.add(createConnectionsReference(N, S, W, E));
                name = br.readLine();
            }

            for(int i = 0; i < rooms.size(); i++) {
                Room r = rooms.get(i);
                Map<Directions, String> conn = connections.get(i);
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

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("I could not load the game map.");
        }
        return map;
    }

    private Map<Directions, String> createConnectionsReference(String n, String s, String w, String e) {
        Map<Directions, String> reference = new HashMap<>();
        reference.put(Directions.N, n);
        reference.put(Directions.S, s);
        reference.put(Directions.W, w);
        reference.put(Directions.E, e);
        return reference;
    }

    private String extractDestinationName(String dest) {
        if(dest.length() > 1) {
            return dest.substring(2);
        }

        return null;
    }

    private Item parseItemData(String itemData, String description) {
        Item item;
        String[] parts = itemData.split("-"); // [0]-> matchers; [1] -> grabbable or not
        String[] matchers = parts[0].split(","); // [0] -> name: [1..] -> all other matchers
        if(parts[1].equals("y")) {
            item = new GrabbableItem(matchers[0], description, new ItemEffect(0, 0, 0, 0, 0));
        } else {
            item = new Item(matchers[0], description);
        }
        for(int i = 1; i < matchers.length; i++) {
            item.getMatchers().add(matchers[i]);
        }
        return item;
    }

}
