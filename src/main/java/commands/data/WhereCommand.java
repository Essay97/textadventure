package commands.data;

import commands.Command;
import entities.people.Player;

public class WhereCommand implements Command {
    private final Player player;

    public WhereCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println("You are in " + player.getCurrentRoom().getName());
        System.out.println(player.getCurrentRoom().examine());
    }

    @Override
    public void unexecute() {
        throw new UnsupportedOperationException(getClass().getSimpleName() + "cannote be unexecuted");
    }

    @Override
    public boolean canUnexecute() {
        return false;
    }
}
