package setup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.GameMap;

import java.io.File;
import java.io.IOException;

public class JsonMapBuildStrategy implements MapBuildStrategy {

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
