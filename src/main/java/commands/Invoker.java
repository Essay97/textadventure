package commands;

import java.util.Stack;

public class Invoker {

    private Stack<Command> history = new Stack<>();

    public void invoke(Command command) {
        command.execute();
        if (command.canUnexecute()) {
            history.push(command);
        }
    }

    public void uninvoke() {
        if (!history.isEmpty()) {
            Command last = history.pop();
            last.unexecute();
        } else {
            System.out.println("But you did nothing...");
        }
    }

}
