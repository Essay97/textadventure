package commands;

/**
 * This interface gives a general structure to a command
 */
public interface Command {
    /**
     * Runs the command
     */
    void execute();

    /**
     * Rolls back the effect of the command
     */
    void unexecute();

    /**
     * @return <code>true</code> if this command is intended to be unexecuted (i.e. implement {@link #unexecute()}
     */
    boolean canUnexecute();
}
