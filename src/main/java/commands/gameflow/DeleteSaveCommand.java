package commands.gameflow;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import commands.Command;

/**
 * Deletes the saved game session. All data will be lost. It is triggered by the word <code>delete</code>
 */
public class DeleteSaveCommand implements Command {

    @Override
    public void execute() {
        try {
            PrintWriter playerWriter = new PrintWriter("player.txt");
            playerWriter.close();
            PrintWriter stateWriter = new PrintWriter("state.txt");
            stateWriter.close();
            System.out.println("I deleted your progress.");
        } catch (FileNotFoundException e) {
            System.out.println("I don't know what went wrong... maybe you can retry?");
        }
    }

    @Override
    public void unexecute() {
        throw new UnsupportedOperationException(getClass().getSimpleName() + "cannot be unexecuted");
    }

    @Override
    public boolean canUnexecute() {
        return false;
    }

}
