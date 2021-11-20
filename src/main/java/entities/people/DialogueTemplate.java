package entities.people;

import utils.Input;

import java.util.ArrayList;
import java.util.List;

public class DialogueTemplate implements Dialogue {
    List<DialogueChunk> chunks = new ArrayList<>();

    @Override
    public void doDialogue() {
        for (DialogueChunk chunk : chunks) {
            int choice;
            while(true) {
                try {
                    String input = Input.prompt();
                    choice = Integer.parseInt(input);
                    System.out.println("YOU: "+chunk.getResponses().get(choice-1));
                    System.out.println("MUM: Ok then, watch out!");
                    break;
                } catch (Exception e) {
                    System.out.println("Choose one from the options!");
                }
            }
        }
    }
}
