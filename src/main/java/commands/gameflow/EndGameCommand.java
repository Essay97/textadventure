package commands.gameflow;

import commands.Command;
import entities.GameState;

public class EndGameCommand implements Command {

    private GameState state;

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
