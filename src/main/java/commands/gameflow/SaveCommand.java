package commands.gameflow;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import commands.Command;
import entities.GameState;
import entities.people.Player;

/**
 * Saves the current state of the game. It is triggered by the word <code>save</code>
 */
public class SaveCommand implements Command {

    private final GameState state;
    private final Player player;

    public SaveCommand(Player player, GameState state) {
        super();
        this.state = state;
        this.player = player;
    }

    @Override
    public void execute() {
        try {
            // Save player
            FileOutputStream filePlayer = new FileOutputStream("player.txt");
            ObjectOutputStream playerStream = new ObjectOutputStream(filePlayer);
            playerStream.writeObject(player);
            playerStream.close();

            // Save game state
            FileOutputStream fileState = new FileOutputStream("state.txt");
            ObjectOutputStream stateStream = new ObjectOutputStream(fileState);
            stateStream.writeObject(state);
            stateStream.close();

            System.out.println("Game saved.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("It seems like I could not find the file. I was unable to save, retry.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong while I was saving... Please, retry.");
        }
    }

    @Override
    public void unexecute() {
        throw new UnsupportedOperationException(getClass().getSimpleName() + " cannot be unexecuted");
    }

    @Override
    public boolean canUnexecute() {
        return false;
    }

}
