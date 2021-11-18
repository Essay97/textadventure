package utils;

import java.util.Random;

import entities.people.Fighter;

public class FighterUtil {
    public static int getAttack(Fighter f) {
        Random random = new Random();

        return 1 + random.nextInt(f.getMaxAttack() - 1);
    }
}
