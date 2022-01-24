package setup;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import entities.GrabbableItem;
import entities.Item;
import entities.ItemEffect;

import java.io.IOException;
import java.util.Iterator;

public class ItemDeserializer extends JsonDeserializer<Item> {
    @Override
    public Item deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectMapper om = new ObjectMapper();

        ObjectNode root = jsonParser.getCodec().readTree(jsonParser);

        boolean grab = root.get("grab").asBoolean();

        Item item = null;
        if (grab){
            JsonNode mods = root.get("modifiers");

            item = new GrabbableItem(root.get("name").asText(), root.get("description").asText(),
                    new ItemEffect(
                            extractItemEffect("HP", mods),
                            extractItemEffect("attack", mods),
                            extractItemEffect("burn", mods),
                            extractItemEffect("poison", mods),
                            extractItemEffect("stun", mods),
                            root.get("oneShot").asBoolean()
                    ));

        } else {
            item = new Item(root.get("name").asText(), root.get("description").asText());
        }
        Iterator<JsonNode> i = root.get("matchers").elements();
        while (i.hasNext()) {
            item.getMatchers().add(i.next().asText());
        }

        return item;
    }

    private int extractItemEffect(String key, JsonNode node) {
        if(node.has(key)) {
            return node.get(key).asInt();
        } else {
            return 0;
        }
    }
}
