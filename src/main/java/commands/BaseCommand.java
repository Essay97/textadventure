package commands;

import entities.GameState;

/**
 * This is the basic implementation of a command that can be unexecuted.
 * <p><strong>If you don't want your command to be unexecutable, just implement {@link Command} directly.</strong></p>
 */
public abstract class BaseCommand implements Command {
    /**
     * The game state at this moment
     */
    private final GameState state;

    public BaseCommand(GameState state) {
        super();
        this.state = state;
    }

    /**
     * Runs the command and handles action count
     */
    @Override
    public void execute() {
        doAction();
        state.incrementActionsCount();
    }

    /**
     * Rolls back the effect of the command and handles action count
     */
    @Override
    public void unexecute() {
        undoAction();
        state.decreaseActionsCount();
    }

    /**
     * The actual effect of the concrete command
     */
    public abstract void doAction();

    /**
     * The actual rollback of the concrete command. The default is UnsupportedOperandException
     */
    public void undoAction() {
        throw new UnsupportedOperationException(getClass().getSimpleName() + " cannot be unexecuted");
    }

}
