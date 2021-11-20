package entities.people;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DialogueChunk {
    private String message;
    private List<String> responses;

    public String getMessage() {
        return message;
    }

    public List<String> getResponses() {
        return responses;
    }
}
