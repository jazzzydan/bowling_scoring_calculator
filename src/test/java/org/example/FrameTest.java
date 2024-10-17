package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrameTest {


    @Test
    void getFirstRollPins() {
        Frame frame = new Frame(7);
        frame.setSecondRollPins(1);
        assertEquals(7,frame.getFirstRollPins());
    }

    @Test
    void getSecondRollPins() {
        Frame frame = new Frame(5);
        frame.setSecondRollPins(3);
        assertEquals(3,frame.getSecondRollPins());
    }

    @Test
    void getPins() {
        Frame frame = new Frame(7);
        frame.setSecondRollPins(1);
        assertEquals(8,frame.getPins());
    }

    @Test
    void getScore() {
        Frame frame = new Frame(3);
        frame.setSecondRollPins(1);
        assertEquals(4,frame.getScore());
    }

    @Test
    void isOpen() {
        Frame frame = new Frame(3);
        assertTrue(frame.isOpen());
        frame.setSecondRollPins(2);
        assertFalse(frame.isOpen());
    }

    @Test
    void isSpare(){
        Frame frame = new Frame(3);
        frame.setSecondRollPins(7);
        assertTrue(frame.isSpare());
        frame.setSecondRollPins(2);
        assertFalse(frame.isSpare());
    }

    @Test
    void isStrike(){
        Frame frame = new Frame(10);
        frame.setSecondRollPins(0);
        assertTrue(frame.isStrike());
        frame = new Frame(2);
        frame.setSecondRollPins(2);
        assertFalse(frame.isStrike());
    }

    @Test
    void toStringStrike(){
        Frame frame = new Frame(10);
        frame.setSecondRollPins(0);
        assertEquals("X -", frame.toString());
    }

    @Test
    void toStringSpare(){
        Frame frame = new Frame(5);
        frame.setSecondRollPins(5);
        assertEquals("5 /", frame.toString());
    }

    @Test
    void isStringRegular(){
        Frame frame = new Frame(4);
        frame.setSecondRollPins(3);
        assertEquals("4 3", frame.toString());
    }
}