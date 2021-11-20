package entities.people;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import setup.DialogueTemplateDeserializer;

import java.io.Serializable;


@FunctionalInterface
@JsonDeserialize(using = DialogueTemplateDeserializer.class)
public interface Dialogue extends Serializable {
    public void doDialogue(String talkerName);
}
