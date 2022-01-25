package commands;

import entities.people.Player;
import utils.Output;

/**
 * Prints out the content of the inventory. It is triggered by the word <code>inventory</code>
 */
public class InventoryCommand implements Command {
    private final Player player;

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
