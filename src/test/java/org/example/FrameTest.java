package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrameTest {
    @Test
    void getFirstRollPins() {
        var frame = new Frame(7);
        frame.setSecondRollPins(1);
        assertEquals(7, frame.getFirstRollPins());
    }

    @Test
    void getSecondRollPins() {
        var frame = new Frame(5);
        frame.setSecondRollPins(3);
        assertEquals(3, frame.getSecondRollPins());
    }

    @Test
    void getPins() {
        var frame = new Frame(7);
        frame.setSecondRollPins(1);
        assertEquals(8, frame.getPins());
    }

    @Test
    void getScore() {
        var frame = new Frame(3);
        frame.setSecondRollPins(1);
        assertEquals(4, frame.getScore());
    }

    @Test
    void isOpen() {
        var frame = new Frame(3);
        assertTrue(frame.isOpen());
        frame.setSecondRollPins(2);
        assertFalse(frame.isOpen());
    }

    @Test
    void isSpare() {
        var frame = new Frame(3);
        frame.setSecondRollPins(7);
        assertTrue(frame.isSpare());
        frame.setSecondRollPins(2);
        assertFalse(frame.isSpare());
    }

    @Test
    void isStrike() {
        var frame = new Frame(10);
        frame.setSecondRollPins(0);
        assertTrue(frame.isStrike());
        frame = new Frame(2);
        frame.setSecondRollPins(2);
        assertFalse(frame.isStrike());
    }

    @Test
    void toStringStrike() {
        var frame = new Frame(10);
        frame.setSecondRollPins(0);
        assertEquals("X -", frame.toString());
    }

    @Test
    void toStringSpare() {
        var frame = new Frame(5);
        frame.setSecondRollPins(5);
        assertEquals("5 /", frame.toString());
    }

    @Test
    void isStringRegular() {
        var frame = new Frame(4);
        frame.setSecondRollPins(3);
        assertEquals("4 3", frame.toString());
    }
}