package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingScoreCalculatorTest {
    BowlingScoreCalculator calc = new BowlingScoreCalculator();

    @Test
    void oneRoll() {
        calc.roll(6);
        assertEquals(6, calc.score());
    }

    @Test
    void twoRolls() {
        calc.roll(1);
        calc.roll(2);
        assertEquals(3, calc.score());
    }
}