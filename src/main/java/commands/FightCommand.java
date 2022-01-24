package commands;

import entities.GameState;
import entities.GrabbableItem;
import entities.people.Fighter;
import entities.people.Player;
import utils.Input;

import java.util.List;

/**
 * Starts a fight sequence against a specific target. It is triggered by the word <code>fight</code>
 */
public class FightCommand extends BaseCommand {

    private Fighter f1;
    private Fighter f2;

    public FightCommand(GameState state, Fighter f1, Fighter f2) {
        super(state);
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public boolean canUnexecute() {
        return false;
    }

    @Override
    public void doAction() {
        if(f1 == null || f2 == null) {
            System.out.println("No one with that name wants to fight you.");
        } else {
            System.out.println("FIGHT STARTS!");
            while(f1.getHP() > 0 && f2.getHP() > 0) {
                applyStatus(f1);
                if(f1.getStunned() < 1) {
                    chooseAction(f1, f2);
                }
                if(f2.getHP() > 0) {
                    applyStatus(f2);
                    if(f2.getStunned() < 1) {
                        chooseAction(f2, f1);
                    }
                }
            }
            if(f1.getHP() <= 0) {
                System.out.println(f1.getName() + " lost!");
            } else if(f2.getHP() <= 0) {
                System.out.println(f2.getName() + " lost!");
            } else {
                System.out.println("It's a tie.");
            }
        }
    }

    @Override
    public void undoAction() {
        throw new UnsupportedOperationException(getClass().getSimpleName()+" cannot be unexecuted");
    }

    private void chooseAction(Fighter fighter, Fighter target) {
        if(fighter instanceof Player) {
            System.out.println("What do you want to do?");
            System.out.println("\t1 - attack");
            System.out.println("\t2 - defend");
            System.out.println("\t3 - use item");
            while(true) {
                try {
                    String input = Input.prompt();
                    int choice = Integer.parseInt(input);
                    if(choice == 1) {
                        fighter.attack(target);
                    } else if(choice == 2) {
                        fighter.setDefending(true);
                    } else if(choice == 3) {
                        //TODO implement item usage during fight
                        List<GrabbableItem> inventory = ((Player) fighter).getInventory();
                        if(!inventory.isEmpty()) {
                            System.out.println("Which item do you want to use?");
                            for(int i = 0; i < inventory.size(); i++) {
                                System.out.println((i+1) + " - " + inventory.get(i).getName());
                            }
                            int itemChoice = Input.intPrompt();
                            System.out.println("You choose "  + itemChoice);

                        } else {
                            System.out.println("You don't have any items to use...");
                        }
                    }
                    break;
                } catch(Exception e) {
                    System.out.println("Choose one of the options.");
                }
            }
        } else {
            // NPCs always attack
            fighter.attack(target);
        }
    }

    private void applyStatus(Fighter fighter) {
        if(fighter.getBurned() > 0) {
            fighter.setHP(fighter.getHP() - 1);
            fighter.setBurned(fighter.getBurned() - 1);
        }
        if(fighter.getPoisoned() > 0) {
            fighter.setHP(fighter.getHP() - 2);
            fighter.setPoisoned(fighter.getPoisoned() - 1);
        }
    }

}
