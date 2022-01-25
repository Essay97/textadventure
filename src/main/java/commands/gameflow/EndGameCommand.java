package commands.gameflow;

import commands.Command;
import entities.GameState;

/**
 * Ends the game and stops the run. If not manually saved, the game data will be lost after the invocation of this command.
 * It is triggered by the word <code>quit</code>
 */
public class EndGameCommand implements Command {

    private final GameState state;

    public EndGameCommand(GameState state) {
        super();
        this.state = state;
    }

    @Override
    public void execute() {
        state.setRunning(false);
        System.out.println("Game stopped.");
    }

    @Override
    public void unexecute() {
        state.setRunning(true);
    }

    @Override
    public boolean canUnexecute() {
        return true;
    }

}
