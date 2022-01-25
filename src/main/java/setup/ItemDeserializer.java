package setup;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import entities.EquipItem;
import entities.GrabbableItem;
import entities.Item;
import entities.ItemEffect;
import utils.EquipParts;

import java.io.IOException;
import java.util.Iterator;

public class ItemDeserializer extends JsonDeserializer<Item> {
    @Override
    public Item deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectNode root = jsonParser.getCodec().readTree(jsonParser);

        boolean grab = extractBoolean("grab", root);

        Item item;
        if (grab){
            JsonNode mods = root.get("modifiers");
            if(extractBoolean("oneShot", root)) {
                item = new GrabbableItem(root.get("name").asText(), root.get("description").asText(),
                        new ItemEffect(
                                extractItemEffect("HP", mods),
                                extractItemEffect("attack", mods),
                                extractItemEffect("burn", mods),
                                extractItemEffect("poison", mods),
                                extractItemEffect("stun", mods)
                        ));
            } else {
                item = new EquipItem(root.get("name").asText(), root.get("description").asText(),
                        new ItemEffect(
                                extractItemEffect("HP", mods),
                                extractItemEffect("attack", mods),
                                extractItemEffect("burn", mods),
                                extractItemEffect("poison", mods),
                                extractItemEffect("stun", mods)
                        ), extractEquipPart(root));
            }


        } else {
            item = new Item(root.get("name").asText(), root.get("description").asText());
        }
        if(root.has("matchers")) {
            Iterator<JsonNode> i = root.get("matchers").elements();
            while (i.hasNext()) {
                item.getMatchers().add(i.next().asText());
            }
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

    private boolean extractBoolean(String key, JsonNode node) {
        if(node.has(key)) {
            return node.get(key).asBoolean();
        } else {
            return false;
        }
    }

    private EquipParts extractEquipPart(JsonNode node) {
        String part = node.get("part").asText();
        switch (part) {
            case "AtkHand":
                return EquipParts.AtkHand;
            case "DefHand":
                return EquipParts.DefHand;
            case "Foot":
                return EquipParts.Foot;
            case "Head":
                return EquipParts.Head;
            case "Neck":
                return EquipParts.Neck;
            case "Wrist":
                return EquipParts.Wrist;
            case "Body":
                return EquipParts.Body;
        }

        return null;
    }
}
