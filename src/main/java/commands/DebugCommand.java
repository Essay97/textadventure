package commands;

import entities.people.Player;

public class DebugCommand implements Command {

    final Player player;

    public DebugCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println("PLAYER DATA: ");
        System.out.println("HPP : " + player.getHP());
        System.out.println("ATK : " + player.getMaxAttack());
        System.out.println("POT : " + player.getPoisoned());
        System.out.println("BRN : " + player.getBurned());
        System.out.println("STN : " + player.getStunned());
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
