package commands;

public interface Command {
    public void execute();

    public void unexecute();

    public boolean canUnexecute();
}
