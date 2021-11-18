package utils;

import entities.Matchable;

public class MatchableUtil {

    public static boolean matches(Matchable matchable, String match) {
        return matchable.getMatchers().contains(match);
    }
}
