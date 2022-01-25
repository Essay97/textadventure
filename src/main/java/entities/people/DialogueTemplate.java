package entities.people;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import utils.Input;
import utils.Output;

import java.util.List;

/**
 * This class provides basic implementation of the {@link Dialogue} interface.
 * <p>It just lets you iterate over a list of {@link DialogueChunk} and print each chunk, waiting for a response.</p>
 *
 * @see Dialogue
 * @see DialogueChunk
 */
@JsonDeserialize(as = DialogueTemplate.class)
public class DialogueTemplate implements Dialogue {
    /**
     * The list of all the parts of the dialogue
     */
    final List<DialogueChunk> chunks;

    public DialogueTemplate(List<DialogueChunk> chunks) {
        this.chunks = chunks;
    }

    /**
     * The method simpy iterates over the {@link #chunks} and prints all the messages. For every message, it waits for a
     * valid response and keeps asking until the player submits a valid response.
     * @param talkerName the name of the character who is talking, used to print the talker name at the beginning of the line
     */
    @Override
    public void doDialogue(String talkerName) {
        for (DialogueChunk chunk : chunks) {
            Output.postDelayed(1200, talkerName.toUpperCase()+ ": " +chunk.getMessage());
            for (int i = 0; i < chunk.getResponses().size(); i++) {
                String resp = chunk.getResponses().get(i);
                System.out.println("\t"+ (i+1) + ") " + resp);
            }
            int choice;
            while(true) {
                try {
                    String input = Input.prompt();
                    choice = Integer.parseInt(input);
                    System.out.println("YOU: "+chunk.getResponses().get(choice-1));
                    break;
                } catch (Exception e) {
                    System.out.println("Choose one from the options!");
                }
            }
        }
    }
}
