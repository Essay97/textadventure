package commands.data;

import commands.Command;
import entities.people.Player;

public class WhoCommand implements Command {

    private final Player player;

    public WhoCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println("You are " + player.getName());
        System.out.println(player.examine());
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
