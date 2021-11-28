package setup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import entities.GameMap;

import java.io.File;
import java.io.IOException;

public class YamlMapBuildStrategy implements MapBuildStrategy {
    private String filename;

    public YamlMapBuildStrategy(String filename) {
        this.filename = filename;
    }

    @Override
    public GameMap build() {
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
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