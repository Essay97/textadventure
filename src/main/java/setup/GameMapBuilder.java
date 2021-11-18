package setup;

import entities.GameMap;

public class GameMapBuilder {
    private MapBuildStrategy strategy;

    public GameMapBuilder(MapBuildStrategy strategy) {
        super();
        this.strategy = strategy;
    }

    public GameMap build() {
        return strategy.build();
    }
}
