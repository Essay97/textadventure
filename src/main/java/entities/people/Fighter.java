package entities.people;

import entities.Matchable;
import utils.Output;

public interface Fighter extends Matchable {
    public default void attack(Fighter enemy) {
        int delay = 1200;
        Output.delayed(delay, getName() + " attacks!");
        if(!enemy.isDefending()) {
            int newHP = enemy.getHP() - getAttack();
            enemy.setHP(newHP);
            int printHP = enemy.getHP() < 0 ? 0 : enemy.getHP();
            Output.delayed(delay, enemy.getName() + " has " + printHP + "HP left.");
        } else {
            System.out.println(enemy.getName() + " defends!");
            enemy.setDefending(false);
        }
    }
    public int getHP();
    public int getAttack();
    public int getMaxAttack();
    public void setHP(int hp);
    public String getName();
    public boolean isDefending();
    public void setDefending(boolean def);
}
