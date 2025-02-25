package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {
    BowlingGame calc = new BowlingGame();

    @Test
    void oneRoll() {
        calc.roll(6);
        assertEquals(6, calc.calculateScore());
        assertEquals("""
                | 6   |\s
                | 6   |\s
                Score: 6
                """, calc.toString());
    }

    @Test
    void twoRolls() {
        calc.roll(1);
        calc.roll(2);
        assertEquals(3, calc.calculateScore());
        assertEquals("""
                | 1 2 |\s
                | 3   |\s
                Score: 3
                """, calc.toString());
    }

    @Test
    void twoRollsWithSpare() {
        calc.roll(5);
        calc.roll(5);
        assertEquals(10, calc.calculateScore());
        assertEquals("""
                | 5 / |\s
                | 10  |\s
                Score: 10
                """, calc.toString());
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

    @Test
    void allStrikes() {
        for (int i = 0; i < 10; i++) {
            calc.roll(10);
        }
        calc.roll(10);
        calc.roll(10);

        assertEquals(300, calc.calculateScore());
        assertEquals("""
                | X - | X - | X - | X - | X - | X - | X - | X - | X - | X  X  X  |
                | 30  | 60  | 90  | 120 | 150 | 180 | 210 | 240 | 270 | 300
                Score: 300
                """, calc.toString());
    }

    @Test
    void randomGame() {
        ArrayList<Integer> rolls = new ArrayList<>(
                Arrays.asList(8, 2, 5, 4, 9, 0, 10, 10, 5, 5, 5, 3, 6, 3, 9, 1, 9, 1, 10));
        for (Integer roll : rolls) {
            calc.roll(roll);
        }
        assertEquals(149, calc.calculateScore());
        assertEquals("""
                | 8 / | 5 4 | 9 0 | X - | X - | 5 / | 5 3 | 6 3 | 9 / | 9 / X  |
                | 15  | 24  | 33  | 58  | 78  | 93  | 101 | 110 | 129 | 149
                Score: 149
                """, calc.toString());
    }

    @Test
    void randomGame200() {
        ArrayList<Integer> rolls = new ArrayList<>(
                Arrays.asList(10, 9, 1, 10, 9, 1, 10, 9, 1, 10, 9, 1, 10, 9, 1, 10));
        for (Integer roll : rolls) {
            calc.roll(roll);
        }
        assertEquals(200, calc.calculateScore());
    }

    @Test
    void randomGame73() {
        ArrayList<Integer> rolls = new ArrayList<>(
                Arrays.asList(0, 1, 2, 3, 4, 5, 6, 4, 7, 0, 8, 0, 9, 0, 10, 0, 1, 2, 3));
        for (Integer roll : rolls) {
            calc.roll(roll);
        }
        assertEquals(73, calc.calculateScore());
    }

    @Test
    void spareGame() {
        ArrayList<Integer> rolls = new ArrayList<>(
                Arrays.asList(5, 5, 5, 5, 6, 4, 4, 6, 7, 3, 3, 7, 8, 2, 2, 8, 9, 1, 1, 9, 1));
        for (Integer roll : rolls) {
            calc.roll(roll);
        }
        assertEquals(146, calc.calculateScore());
        assertEquals("""
                | 5 / | 5 / | 6 / | 4 / | 7 / | 3 / | 8 / | 2 / | 9 / | 1 / 1  |
                | 15  | 31  | 45  | 62  | 75  | 93  | 105 | 124 | 135 | 146
                Score: 146
                """, calc.toString());
    }

    @Test
    void secondFrameScore() {
        ArrayList<Integer> rolls = new ArrayList<>(
                Arrays.asList(5, 5, 5, 5, 6, 4, 4, 2));
        for (Integer roll : rolls) {
            calc.roll(roll);
        }
        assertEquals(51, calc.calculateScore());
        assertEquals(15, calc.getScoreAfterFrame(1, 0));
        assertEquals(31, calc.getScoreAfterFrame(2, 0));
        assertEquals(45, calc.getScoreAfterFrame(3, 0));
        assertEquals(51, calc.getScoreAfterFrame(4, 0));
    }

    @Test
    void randomGameFrameScores() {
        ArrayList<Integer> rolls = new ArrayList<>(
                Arrays.asList(8, 2, 5, 4, 9, 0, 10, 10, 5, 5, 5, 3, 6, 3, 9, 1, 9, 1, 10));
        for (Integer roll : rolls) {
            calc.roll(roll);
        }
        assertEquals(15, calc.getScoreAfterFrame(1, 0));
        assertEquals(24, calc.getScoreAfterFrame(2, 0));
        assertEquals(33, calc.getScoreAfterFrame(3, 0));
        assertEquals(58, calc.getScoreAfterFrame(4, 0));
        assertEquals(78, calc.getScoreAfterFrame(5, 0));
        assertEquals(93, calc.getScoreAfterFrame(6, 0));
        assertEquals(101, calc.getScoreAfterFrame(7, 0));
        assertEquals(110, calc.getScoreAfterFrame(8, 0));
        assertEquals(129, calc.getScoreAfterFrame(9, 0));
        assertEquals(149, calc.getScoreAfterFrame(calc.frames.size(), 0));
        assertEquals("""
                | 8 / | 5 4 | 9 0 | X - | X - | 5 / | 5 3 | 6 3 | 9 / | 9 / X  |
                | 15  | 24  | 33  | 58  | 78  | 93  | 101 | 110 | 129 | 149
                Score: 149
                """, calc.toString());
    }
}