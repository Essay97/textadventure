package commands;

import entities.GameState;

public class NumberCommand implements Command {

    private final GameState state;

    public NumberCommand(GameState state) {
        this.state = state;
    }

    @Override
    public void execute() {
        System.out.println(state.getActionsCount() + " actions have been done in this game");
    }
}
