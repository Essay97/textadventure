package setup.strategies;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.GameMap;

import java.io.File;
import java.io.IOException;

/**
 * Builds a map by parsing a JSON file. The file name must be passed as a parameter to the constructor of the strategy.
 * TODO: add link to the user guide
 */
public class JsonMapBuildStrategy implements MapBuildStrategy {

    /**
     * The name of the parsed file
     */
    private final String filename;

    public JsonMapBuildStrategy(String filename) {
        this.filename = filename;
    }

    @Override
    public GameMap build() {
        ObjectMapper om = new ObjectMapper();
        GameMap map = null;
        try {
            System.out.println(filename);
            map = om.readValue(new File(filename), GameMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
