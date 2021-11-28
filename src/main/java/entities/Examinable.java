package entities;

/**
 * This interface gives the ability to use the <code>examine</code> command.
 * An instance of a class that implements this interface can be used as an argument for said command. The interface just
 * provides the behavior to get a suitable description for something that can be used to respond to the command and
 * to change such description.
 *
 * @see Matchable
 * @see Movable
 */
public interface Examinable extends Matchable {
    /**
     * @return the description of the thing
     */
    String examine();

    /**
     * Updates the description returned by {@link #examine()}
     * @param descr the new value
     */
    void setDescription(String descr);
}