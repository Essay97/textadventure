package setup;

import entities.GameMap;

/**
 * This class is responsible for building the map for the game. This can achieved via multiple strategies. Pass the desired
 * build strategy as a parameter when creating an instance of this class and just by calling the {@link #build()} method
 * you will get a fully functional {@link GameMap}
 *
 * @see GameMap
 * @see MapBuildStrategy
 * @see DummyMapBuildStrategy
 * @see YamlMapBuildStrategy
 * @see JsonMapBuildStrategy
 */
public class GameMapBuilder {
    /**
     * The strategy chooen for the {@link GameMap} instantiation
     */
    private final MapBuildStrategy strategy;

    public GameMapBuilder(MapBuildStrategy strategy) {
        super();
        this.strategy = strategy;
    }

    /**
     * @return a fully functional map built with the given strategy
     */
    public GameMap build() {
        return strategy.build();
    }
}
