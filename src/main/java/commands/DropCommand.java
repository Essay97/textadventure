package commands;

import entities.GameState;
import entities.GrabbableItem;
import entities.people.Player;

/**
 * Drops an {@link entities.Item} in the inventory. It is triggered by the word <code>drop</code>
 */
public class DropCommand extends BaseCommand {

    /**
     * The player that holds the item to be dropped
     */
    private final Player player;
    /**
     * The item to be dropped
     */
    private final GrabbableItem item;

    public DropCommand(Player player, GameState state, GrabbableItem item) {
        super(state);
        this.player = player;
        this.item = item;
    }


    @Override
    public boolean canUnexecute() {
        return true;
    }

    @Override
    public void doAction() {
        if(item != null) {
            player.removeInventoryItem(item);
            System.out.println("You threw " + item.getName() + " away.");
            player.getCurrentRoom().addItem(item);
        } else {
            System.out.println("You don't own anything like that");
        }

    }

    @Override
    public void undoAction() {
        player.addInventoryItem(item);
        System.out.println("You put " + item.getName() + " back in your inventory.");
    }

}
