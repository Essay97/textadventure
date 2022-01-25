package utils;

import entities.people.Fighter;
import entities.people.Player;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FighterUtilTest {

    @Test
    void getAttack() {
        Fighter f = new Player("TestPlayer", "description in test");
        int atk = FighterUtil.getAttack(f);
        assertTrue(atk > 0 && atk < f.getMaxAttack());
    }
}