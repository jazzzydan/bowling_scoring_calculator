package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BowlingScoreCalculatorTest {
    BowlingScoreCalculator calc = new BowlingScoreCalculator();

    @Test
    void oneRoll() {
        calc.roll(6);
        assertEquals(6, calc.calculateScore());
    }

    @Test
    void twoRolls() {
        calc.roll(1);
        calc.roll(2);
        assertEquals(3, calc.calculateScore());
    }

    @Test
    void twoRollsWithSpare() {
        calc.roll(5);
        calc.roll(5);
        assertEquals(10, calc.calculateScore());
    }

    @Test
    void isSpare() {
        calc.roll(5);
        calc.roll(5);
        assertTrue(calc.frames.getLast().isSpare());
    }

    @Test
    void addSpareBonusToPreviousIfSpare() {
        calc.roll(6);
        calc.roll(4);
        calc.roll(3);
        calc.roll(3);

        assertEquals(2, calc.frames.size());
        assertEquals(6, calc.frames.getLast().getScore());
        assertEquals(19, calc.calculateScore());
    }

    @Test
    void addBonusIfStrike() {
        calc.roll(10);
        calc.roll(5);
        calc.roll(3);

        assertEquals(2, calc.frames.size());
        assertEquals(8, calc.frames.getLast().getScore());
        assertEquals(26, calc.calculateScore());
    }

    @Test
    void twoFirstStrikes() {
        calc.roll(10);
        calc.roll(10);
        assertEquals(30, calc.calculateScore());
    }

    @Test
    void consecutiveStrikes() {
        for (int i = 0; i < 9; i++) {
            calc.roll(10);
        }
        assertEquals(240, calc.calculateScore());
    }

    @Test
    void twoFrames() {
        calc.roll(10);

        calc.roll(4);
        calc.roll(5);

        assertEquals(28, calc.calculateScore());
    }

    @Test
    void threeFrames() {
        calc.roll(10);
        calc.roll(10);

        calc.roll(4);
        calc.roll(0);

        assertEquals(42, calc.calculateScore());
    }

//    @Test
//    void allStrikes() {
//        for (int i = 0; i < 10; i++) {
//            calc.roll(10);
//        }
//        calc.roll(10);
//        calc.roll(10);
//
//        assertEquals(300, calc.calculateScore());
//    }
//
//
//    @Test
//    void randomGame() {
//
//        ArrayList<Integer> rolls = new ArrayList<>(
//                Arrays.asList(8, 2, 5, 4, 9, 1, 10, 10, 5, 5, 5, 3, 6, 3, 9, 1, 9, 1, 10));
//        for (Integer roll : rolls) {
//            calc.roll(roll);
//        }
//        assertEquals(149, calc.calculateScore());
//    }
}