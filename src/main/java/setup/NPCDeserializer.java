package setup;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.people.FighterNPC;
import entities.people.FighterTalkerNPC;
import entities.people.NPC;
import entities.people.TalkerNPC;

import java.io.IOException;

public class NPCDeserializer extends JsonDeserializer<NPC> {
    @Override
    public NPC deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectMapper om = new ObjectMapper();

        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        boolean isTalker = root.get("dialogue") != null;
        boolean isFighter = root.get("hp") != null && root.get("maxAttack") != null;
        NPC npc = null;
        if (isFighter && isTalker) {
            npc = om.treeToValue(root, FighterTalkerNPC.class);
        } else if (isFighter) {
            npc = om.treeToValue(root, FighterNPC.class);
        } else if (isTalker) {
            npc = om.treeToValue(root, TalkerNPC.class);
        }
        if(npc != null) {
            npc.getMatchers().add(npc.getName());
        }

        return npc;
    }
}
