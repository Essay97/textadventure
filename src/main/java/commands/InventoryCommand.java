package commands;

import entities.people.Player;
import utils.Output;

public class InventoryCommand implements Command {
    private Player player;

    public InventoryCommand(Player player) {
        super();
        this.player = player;
    }

    @Override
    public void execute() {
        Output.inventory(player);
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
