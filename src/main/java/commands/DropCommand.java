package commands;

import entities.GameState;
import entities.GrabbableItem;
import entities.people.Player;

public class DropCommand extends BaseCommand {

    private Player player;
    private GrabbableItem item;

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
