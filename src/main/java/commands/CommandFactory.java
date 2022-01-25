package commands;

import java.util.Collection;

import commands.gameflow.DeleteSaveCommand;
import commands.gameflow.EndGameCommand;
import commands.gameflow.SaveCommand;
import commands.movement.MoveECommand;
import commands.movement.MoveNCommand;
import commands.movement.MoveSCommand;
import commands.movement.MoveWCommand;
import entities.Examinable;
import entities.GameState;
import entities.GrabbableItem;
import entities.Matchable;
import entities.people.Fighter;
import entities.people.Player;
import entities.people.Talker;

/**
 * This class is responsible for creating commands based on the text typed by the player.
 */
public class CommandFactory {
    /**
     * Creates the command
     * @param input user input
     * @param player player of the current game
     * @param state current state of the game
     * @return the wanted command
     */
    public static Command makeCommand(String input, Player player, GameState state) {
        switch (input) {
            // MOVEMENT
            case "move N":
                return new MoveNCommand(player, state);
            case "move S":
                return new MoveSCommand(player, state);
            case "move W":
                return new MoveWCommand(player, state);
            case "move E":
                return new MoveECommand(player, state);
            // GAME FLOW
            case "quit":
                return new EndGameCommand(state);
            case "save":
                return new SaveCommand(player, state);
            case "delete":
                return new DeleteSaveCommand();
            // UNDO -> returns null
            case "undo":
                return null;
            // INVENTORY
            case "inventory":
                return new InventoryCommand(player);
            case "debug":
                return new DebugCommand(player);
        }

        // More complex commands since a match has to be found

        // EXAMINE
        if (input.startsWith("examine")) {
            String match = extractArgument("examine", input);
            if(match != null) {
                Examinable item = findExaminable(player, match);
                return new ExamineCommand(item, state);
            }
        }

        // GRAB
        if (input.startsWith("grab")) {
            String match = extractArgument("grab", input);
            if(match != null) {
                GrabbableItem item = findGrabbable(player, match);
                return new GrabCommand(player, state, item);
            }
        }

        // DROP
        if (input.startsWith("drop")) {
            String match = extractArgument("drop", input);
            if(match != null) {
                GrabbableItem item = findInInventory(player, match);
                return new DropCommand(player, state, item);
            }
        }

        // TALK
        if (input.startsWith("talk")) {
            String match = extractArgument("talk", input);
            if(match != null) {
                Talker talker = findTalker(player, match);
                return new TalkCommand(state, talker);
            }
        }

        // FIGHT
        if (input.startsWith("fight")) {
            String match = extractArgument("fight", input);
            if(match != null) {
                Fighter fighter = findFighter(player, match);
                return new FightCommand(state, player, fighter);
            }
        }

        // USE ITEM
        if (input.startsWith("use")) {
            String match = extractArgument("use", input);
            if (match != null) {
                GrabbableItem item = findInInventory(player, match);
                return new UseItemCommand(player, item);
            }

        }

        return new NoCommand();
    }

    private static Talker findTalker(Player p, String match) {
        return (Talker) findMatchableForceInstance(p.getCurrentRoom().getNpcs(), match, Talker.class);
    }

    private static Examinable findExaminable(Player p, String match) {
        Examinable found = null;
        Examinable check;

        // Check player
        if (p.matches(match)) {
            found = p;
        }

        // Check current room
        if (p.getCurrentRoom().matches(match)) {
            found = p.getCurrentRoom();
        }

        // Check items in room
        check = (Examinable) findMatchable(p.getCurrentRoom().getItems(), match);
        if(check != null) found = check;

        // Check items in inventory
        check = (Examinable) findMatchable(p.getInventory(), match);
        if(check != null) found = check;

        // Check NPCs
        check = (Examinable) findMatchable(p.getCurrentRoom().getNpcs(), match);
        if(check != null) found = check;

        // Check items in equipment
        check = (Examinable) findMatchable(p.getEquip().values(), match);
        if(check != null) found = check;

        return found;
    }

    private static GrabbableItem findGrabbable(Player p, String match) {
        return (GrabbableItem) findMatchableForceInstance(
                p.getCurrentRoom().getItems(), match, GrabbableItem.class);
    }

    private static GrabbableItem findInInventory(Player p, String match) {
        return (GrabbableItem) findMatchable(p.getInventory(), match);
    }

    private static Fighter findFighter(Player p, String match) {
        return (Fighter) findMatchableForceInstance(p.getCurrentRoom().getNpcs(), match, Fighter.class);
    }

    private static Matchable findMatchable(Collection<? extends Matchable> matchables, String match) {
        return matchables.stream().filter(m -> m.matches(match))
                .findFirst().orElse(null);
    }

    private static Matchable findMatchableForceInstance(Collection<? extends Matchable> matchables,
                                                        String match, Class<?> clazz) {

        return matchables.stream().filter(m -> clazz.isInstance(m) && m.matches(match))
                .findFirst().orElse(null);
    }

    private static String extractArgument(String cmd, String input) {
        String match = input.substring(cmd.length()).trim();
        if (match.equals("")) {
            System.out.println("Wait... " + cmd + " who? What?");
            return null;
        }
        return match;
    }
}