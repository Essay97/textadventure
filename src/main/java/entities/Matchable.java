package entities;

import java.util.Set;

/**
 * This interface gives the ability to be used as a command argument. The implementer gets the ability to be found when
 * invoked as a command parameter.
 *
 * @see Examinable
 * @see Movable
 * @see entities.people.Fighter
 * @see entities.people.Talker
 */
public interface Matchable {
    /**
     * @return the set of all the strings that can be used as command arguments in order to trigger the match with this
     * object
     */
    public Set<String> getMatchers();

    /**
     * Given the string passed as parameter to the command, this returns <code>true</code> if the string is a suitable
     * identifier for the object
     * @param id the string parameter of a command
     * @return a boolean that represents the match
     */
    public boolean matches(String id);
}
