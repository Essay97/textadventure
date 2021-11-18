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

public class CommandFactory {
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
        }

        // More complex commands since a match has to be found

        // EXAMINE
        if (input.startsWith("examine")) {
            String match = input.substring(8); // cut "examine" and keep the rest
            Examinable item = findExaminable(player, match);
            return new ExamineCommand(item, state);
        }

        // GRAB
        if (input.startsWith("grab")) {
            String match = input.substring(5); // cut "grab" and leave the rest
            GrabbableItem item = findGrabbable(player, match);
            return new GrabCommand(player, state, item);
        }

        // DROP
        if (input.startsWith("drop")) {
            String match = input.substring(5); // cut "drop" and leave the rest
            GrabbableItem item = findInInventory(player, match);
            return new DropCommand(player, state, item);
        }

        // TALK
        if (input.startsWith("talk")) {
            String match = input.substring(5); // cut "talk" and leave the rest
            Talker talker = findTalker(player, match);
            return new TalkCommand(state, talker);
        }

        // FIGHT
        if (input.startsWith("fight")) {
            String match = input.substring(6); // cut "fight" and leave the rest
            Fighter fighter = findFighter(player, match);
            return new FightCommand(state, player, fighter);
        }

        return new NoCommand();
    }

    private static Talker findTalker(Player p, String match) {
        return (Talker) findMatchableForceInstance(p.getCurrentRoom().getNpcs(), match, Talker.class);
    }

    private static Examinable findExaminable(Player p, String match) {
        Examinable found = null;
        Examinable check = null;

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
        Matchable matchable = matchables.stream().filter(
                        m -> clazz.isInstance(m) && m.matches(match))
                .findFirst().orElse(null);

        return matchable;
    }
}