package setup.strategies;

import entities.GameMap;

/**
 * This interface represents a generic way of building a map
 */
public interface MapBuildStrategy {
    /**
     * @return a fully functional map, built in various ways defined in the concrete implementation of the interface
     */
    GameMap build();
}
