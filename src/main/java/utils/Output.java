package utils;

import java.util.concurrent.TimeUnit;

import entities.Item;
import entities.people.Player;

public class Output {
    public static void position(Player p) {
        System.out.println("You are in " + p.getCurrentRoom().getName());
        System.out.println(p.getCurrentRoom().examine());
    }

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

    public static void delayed(int ms, String msg) {
        try {
            System.out.println(msg);
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void delayedOneLiner(int ms, Iterable<String> chunks) {
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
