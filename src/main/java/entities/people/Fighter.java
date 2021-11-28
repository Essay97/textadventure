package entities.people;

import entities.Matchable;
import utils.Output;

/**
 * The interface gives the ability to use the <code>fight</code> command.
 * Instances of a class that implements this interface can be passed to {@link commands.FightCommand}. It also adds
 * the ability to be targeted as a command argument (not only for the <code>fight</code> command but also for all the other
 * ones such as <code>examine</code>)
 *
 * @see FighterNPC
 * @see FighterTalkerNPC
 * @see commands.FightCommand
 */
public interface Fighter extends Matchable {
    /**
     * This is the default attack sequence: once every turn during a fight, this method is called. It takes care of both
     * managing the fight (inflicting damage, checking defense conditions and so on) and printing messages on the
     * screen for the player.
     * @param enemy the other character involved in the fight
     */
    default void attack(Fighter enemy) {
        int delay = 1200;
        Output.postDelayed(delay, getName() + " attacks!");
        if(!enemy.isDefending()) {
            int newHP = enemy.getHP() - getAttack();
            enemy.setHP(newHP);
            int printHP = Math.max(enemy.getHP(), 0);
            Output.postDelayed(delay, enemy.getName() + " has " + printHP + "HP left.");
        } else {
            System.out.println(enemy.getName() + " defends!");
            enemy.setDefending(false);
        }
    }
    /**
     * @return the amount of damage that the character can suffer at that specific moment before dying.
     */
    int getHP();
    /**
     * @return the damage inflicted by one specific attack
     */
    int getAttack();

    /**
     * @return the maximum damage delivered with a single attack
     */
    int getMaxAttack();

    /**
     * Updates the value returned by {@link #getHP()}
     * @param hp the new value
     */
    void setHP(int hp);

    /**
     * @return the name of the character that's fighting
     */
    String getName();

    /**
     * @return true if the character cannot take damage
     */
    boolean isDefending();

    /**
     * Updates the value returned by {@link #isDefending()}
     * @param def the new value
     */
    void setDefending(boolean def);
}
