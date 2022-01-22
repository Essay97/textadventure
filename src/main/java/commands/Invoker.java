package commands;

import java.util.Stack;


/**
 * This class is responsible for invoking, uninvoking and handling the count of commands.
 */
public class Invoker {
    /**
     * The list of all the commands that have been invoked (without being uninvoked)
     */
    private Stack<Command> history = new Stack<>();

    /**
     * Actually invokes the given command
     * @param command the command to be invoked
     */
    public void invoke(Command command) {
        command.execute();
        if (command.canUnexecute()) {
            history.push(command);
        }
    }

    /**
     * Rolls back the last uninvokable command in the {@link #history}
     */
    public void uninvoke() {
        if (!history.isEmpty()) {
            Command last = history.pop();
            last.unexecute();
        } else {
            System.out.println("But you did nothing...");
        }
    }

}
