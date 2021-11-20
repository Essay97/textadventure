package setup;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sun.org.apache.xpath.internal.operations.Bool;
import entities.GrabbableItem;
import entities.Item;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class ItemDeserializer extends JsonDeserializer<Item> {
    @Override
    public Item deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectMapper om = new ObjectMapper();

        ObjectNode root = jsonParser.getCodec().readTree(jsonParser);

        boolean grab = root.get("grab").asBoolean();

        Item item = null;
        if (grab){
            item = new GrabbableItem(root.get("name").asText(), root.get("description").asText());
        } else {
            item = new Item(root.get("name").asText(), root.get("description").asText());
        }
        Iterator<JsonNode> i = root.get("matchers").elements();
        while (i.hasNext()) {
            item.getMatchers().add(i.next().asText());
        }

        return item;
    }
}