package commands;

import entities.GameState;
import entities.GrabbableItem;
import entities.people.Player;

public class GrabCommand extends BaseCommand {

    private Player player;
    private GrabbableItem item;

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
