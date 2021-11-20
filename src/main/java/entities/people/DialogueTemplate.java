package entities.people;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import utils.Input;
import utils.Output;

import java.util.List;

@JsonDeserialize(as = DialogueTemplate.class)
public class DialogueTemplate implements Dialogue {
    List<DialogueChunk> chunks;

    public DialogueTemplate(List<DialogueChunk> chunks) {
        this.chunks = chunks;
    }

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
