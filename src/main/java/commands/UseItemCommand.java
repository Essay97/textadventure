package commands;

import entities.GrabbableItem;
import entities.people.Fighter;
import entities.people.Player;

public class UseItemCommand implements Command {

    private Player player;
    private GrabbableItem item;

    public UseItemCommand(Player player, GrabbableItem item) {
        this.player = player;
        this.item = item;
    }

    @Override
    public void execute() {
        item.useOn(player);
        /* the item gets removed from the inventory: if it was a one shot item, it will be lost. If it was an equippable,
        you can find it in the equip and eventually turn it back to the inventory */
        player.removeInventoryItem(item);
        System.out.println("You used "+item.getName());
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
