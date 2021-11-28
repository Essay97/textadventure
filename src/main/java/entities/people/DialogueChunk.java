package entities.people;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents a single phrase with its respective answer inside a dialogue
 *
 * @see Dialogue
 * @see DialogueTemplate
 */
public class DialogueChunk {
    /**
     * The actual phrase stored in the chunk
     */
    private String message;
    /**
     * The possible responses that the player can give to {@link #message}
     */
    private List<String> responses;

    /**
     * @return {@link #message}
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return {@link #responses}
     */
    public List<String> getResponses() {
        return responses;
    }
}
