package utils;

import java.util.concurrent.TimeUnit;

import entities.Item;
import entities.people.Player;

/**
 * This class helps managing recurrent outputs
 */
public class Output {
    /**
     * Prints the current position of the given player
     * @param p the player whom position will be printed
     */
    public static void position(Player p) {
        System.out.println("You are in " + p.getCurrentRoom().getName());
        System.out.println(p.getCurrentRoom().examine());
    }

    /**
     * Prints the inventory of the given player
     * @param p the player whom inventory will be printed
     */
    public static void inventory(Player p) {
        if (p.getInventory().isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("In your inventory you have:");
            for (Item i : p.getInventory()) {
                System.out.println("  - " + i.getName());
            }
        }
    }

    /**
     * Prints a quick tutorial for the player
     */
    public static void tutorial() {
        System.out.println("GAME COMMANDS");
        System.out.println("- gather information about something: examine *something*");
        System.out.println("- go around and explore: move *direction* (N, S, W, E)");
        System.out.println("- put something in the inventory: grab *something*");
        System.out.println("- open inventory: inventory");
        System.out.println("- talk to someone: talk *someone*");
        System.out.println("- save your game: save");
        System.out.println("- delete all saved data: delete");
        System.out.println("- quit the game (no autosave): quit");
        System.out.println("An undo command is also available");
        System.out.println();
    }

    /**
     * Prints a line of text and then stops the execution for a given time delay
     * @param ms the stop time in milliseconds
     * @param msg the message to be printed
     */
    public static void postDelayed(int ms, String msg) {
        try {
            System.out.println(msg);
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints a line of text one chunk at a time, each chunk on the same line, stopping the execution after each character
     * print.
     * @param ms the stop time in milliseconds
     * @param chunks the chunks of text to be printed
     */
    public static void postDelayedOneLiner(int ms, Iterable<String> chunks) {
        try {
            for(String chunk : chunks) {
                System.out.print(chunk);
                TimeUnit.MILLISECONDS.sleep(ms);
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
