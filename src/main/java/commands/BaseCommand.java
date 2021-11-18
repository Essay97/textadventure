package commands;

import entities.GameState;

public abstract class BaseCommand implements Command {
    private GameState state;

    public BaseCommand(GameState state) {
        super();
        this.state = state;
    }

    @Override
    public void execute() {
        doAction();
        state.incrementActionsCount();
    }

    @Override
    public void unexecute() {
        undoAction();
        state.decreaseActionsCount();
    }

    public abstract void doAction();

    public abstract void undoAction();

}
