package commands;

import entities.people.Player;
import utils.EquipParts;

public class ShowEquipCommand implements Command {
    private final Player player;

    public ShowEquipCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println("Your current equipment is: ");

        for(EquipParts part : EquipParts.values()) {
            String message = part.toString() + ": ";
            try {
                message += player.getEquip().get(part).getName();
            } catch (NullPointerException e) {
                message += "None";
            }
            System.out.println(message);
        }
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
