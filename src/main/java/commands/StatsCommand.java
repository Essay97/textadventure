package commands;

import entities.people.Player;

public class StatsCommand implements Command {

    final Player player;

    public StatsCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println("Your stats are: ");
        System.out.println("HP : \t" + player.getHP());
        System.out.println("Attack: " + player.getMaxAttack());
        System.out.println("Poison: " + player.getPoisoned());
        System.out.println("Burned: " + player.getBurned());
        System.out.println("Stun: \t" + player.getStunned());
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
