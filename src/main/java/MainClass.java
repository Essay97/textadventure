import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import commands.Command;
import commands.CommandFactory;
import commands.Invoker;
import entities.GameMap;
import entities.GameState;
import entities.Item;
import entities.Room;
import entities.people.Player;
import setup.DummyMapBuildStrategy;
import setup.GameMapBuilder;
import setup.JsonMapBuildStrategy;
import setup.YamlMapBuildStrategy;
import utils.Input;
import utils.Output;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {

        Player player = null;
        GameState state = null;

        try {
            // Get player
            FileInputStream playerInput = new FileInputStream("player.txt");
            ObjectInputStream playerStream = new ObjectInputStream(playerInput);
            player = (Player) playerStream.readObject();
            playerStream.close();

            // Get game state
            FileInputStream stateInput = new FileInputStream("state.txt");
            ObjectInputStream stateStream = new ObjectInputStream(stateInput);
            state = (GameState) stateStream.readObject();
            stateStream.close();
            System.out.println("Loaded saved data.");
        } catch (Exception e) {
            // Setup new game
            state = new GameState();
            // GameMapBuilder builder = new GameMapBuilder(new FileMapBuildStrategy("map1.txt"));
            // GameMapBuilder builder = new GameMapBuilder(new DummyMapBuildStrategy());
            // GameMapBuilder builder = new GameMapBuilder(new JsonMapBuildStrategy("map3.json"));
            GameMapBuilder builder = new GameMapBuilder(new YamlMapBuildStrategy("map4.yml"));
            GameMap map = builder.build();

            player = new Player("Enrico", "This is me");
            player.setMap(map);
        }


        Output.tutorial();
        Output.position(player);
        String input = null;
        Invoker invoker = new Invoker();
        while (state.isRunning()) {
            Command cmd = null;
            if (player.getHP() <= 0) {
                Output.delayedOneLiner(800, Arrays.asList(".", ".", "."));
                Output.delayedOneLiner(800, Arrays.asList(".", ".", "."));
                Output.delayedOneLiner(800, Arrays.asList(".", ".", "."));
                System.out.println("You are dead.");
                cmd = CommandFactory.makeCommand("quit", player, state);
            } else {
                input = Input.prompt();
                cmd = CommandFactory.makeCommand(input, player, state);
            }
            if (cmd == null) {
                // user wants to undo
                invoker.uninvoke();
            } else {
                invoker.invoke(cmd);
            }
        }
    }
}

