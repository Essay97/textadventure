package utils;

import java.util.Random;

import entities.people.Fighter;

/**
 * Utility class to be used in {@link Fighter} concrete implementations
 */
public class FighterUtil {
    /**
     * Generates a random value between 1 and the value returned by {@link Fighter#getMaxAttack()} to be used as a damage
     * value for the next attack
     * @param f the fighter that for which the attack value is generated
     * @return the random generated attack value
     */
    public static int getAttack(Fighter f) {
        Random random = new Random();

        return 1 + random.nextInt(f.getMaxAttack() - 1);
    }


}
