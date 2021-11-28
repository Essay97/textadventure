package entities;

/**
 * This interface allows to navigate the map. The implementer of this interface gains the ability to move around between
 * the rooms of a given {@link GameMap}
 *
 * @see entities.people.Player
 * @see GameMap
 */
public interface Movable {
    /**
     * Moves the implementer to the North
     */
    void moveN();

    /**
     * Moves the implementer to the South
     */
    void moveS();

    /**
     * Moves the implementer to the West
     */
    void moveW();

    /**
     * Moves the implementer to the East
     */
    void moveE();

    /**
     * Checks if the implementer can move to the North
     * @return <code>true</code> if there is an open "door" towards the North in the current room
     */
    boolean canMoveN();

    /**
     * Checks if the implementer can move to the South
     * @return <code>true</code> if there is an open "door" towards the South in the current room
     */
    boolean canMoveS();

    /**
     * Checks if the implementer can move to the West
     * @return <code>true</code> if there is an open "door" towards the West in the current room
     */
    boolean canMoveW();

    /**
     * Checks if the implementer can move to the East
     * @return <code>true</code> if there is an open "door" towards the East in the current room
     */
    boolean canMoveE();
}
