package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingScoreCalculatorTest {
    BowlingScoreCalculator calc = new BowlingScoreCalculator();

    @Test
    void oneRoll() {
        calc.roll(6);
        assertEquals(6, calc.frame.getFirstRollPins());
    }

    @Test
    void twoRolls() {
        calc.roll(1);
        calc.roll(2);
        assertEquals(3, calc.score());
    }

    @Test
    void isSpare() {
        calc.roll(5);
        calc.roll(5);
        assertTrue(calc.frames.getLast().isSpare());
    }

    @Test
    void checkPreviousFrameHasSpare() {
        calc.roll(6);
        calc.roll(4);
        calc.roll(3);
        calc.roll(3);

        assertEquals(2, calc.frames.size());
        assertEquals(6, calc.frames.getLast().getScore());

        assertEquals(13, calc.frames.get(0).getScore());
    }
}