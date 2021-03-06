package commands.actions;

import commands.BaseCommand;
import entities.GameState;
import entities.items.GrabbableItem;
import entities.people.Player;

/**
 * Puts in the inventory a {@link GrabbableItem} that's inside the current room. It is triggered by the word <code>grab</code>
 */
public class GrabCommand extends BaseCommand {
    private final Player player;
    private final GrabbableItem item;

    public GrabCommand(Player player, GameState state, GrabbableItem item) {
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
        if (item != null) {
            player.addInventoryItem(item);
            System.out.println("You put " + item.getName() + " in your inventory.");
        } else {
            System.out.println("Oh, you can't grab that");
        }

    }

    @Override
    public void undoAction() {
        player.removeInventoryItem(item);
        System.out.println("You threw " + item.getName() + " away.");
        player.getCurrentRoom().addItem(item);
    }

}
