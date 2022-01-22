package utils;

import entities.Matchable;
import entities.people.Fighter;

/**
 * Utility class to be used in {@link Matchable} concrete implementations
 */
public class MatchableUtil {
    /**
     * Checks if the matchable instance passed as parameter can be identified by the given string
     * @param matchable the matchable thing to check
     * @param match the identifier that should be checked
     * @return <code>true</code> if the <code>matchable</code> parameter can be identified by the <code>match</code>
     */
    public static boolean matches(Matchable matchable, String match) {
        return matchable.getMatchers().contains(match);
    }
}
