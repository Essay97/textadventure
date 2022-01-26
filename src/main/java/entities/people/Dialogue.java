package entities.people;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import setup.serialize.DialogueTemplateDeserializer;

import java.io.Serializable;

/**
 * This interface aims to represent a dialogue sequence inside the game. Every character that can talk, should implement
 * his own version of <i>Dialogue</i> and provide the whole sequence of phrases and possible responses of the player.
 * This should handle also the user input for the response.
 * <p>When deserializing from JSON/YAML this class is deserialized by means of {@link entities.people.DialogueTemplate} </p>
 *
 * @see DialogueTemplate
 * @see DialogueTemplateDeserializer
 */
@FunctionalInterface
@JsonDeserialize(using = DialogueTemplateDeserializer.class)
public interface Dialogue extends Serializable {
    /**
     * This is the actual method that is called when the dialogue sequence starts.
     * @param talkerName the name of the character who is talking
     */
    void doDialogue(String talkerName);
}
