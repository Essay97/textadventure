package commands;

/**
 * Placeholder command that prints an error message. It is triggered when no ohter command can match the user input.
 */
public class NoCommand implements Command {

    @Override
    public void execute() {
        System.out.println("I'm sorry, I don't think I understood...");
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
