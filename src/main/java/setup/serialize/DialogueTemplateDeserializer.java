package setup.serialize;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.people.DialogueChunk;
import entities.people.DialogueTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DialogueTemplateDeserializer extends JsonDeserializer<DialogueTemplate> {
    @Override
    public DialogueTemplate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectMapper om = new ObjectMapper();

        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        List<DialogueChunk> chunks = new ArrayList<>();
        Iterator<JsonNode> i = root.elements();
        while(i.hasNext()) {
            chunks.add(om.treeToValue(i.next(), DialogueChunk.class));
        }

        return new DialogueTemplate(chunks);
    }
}
