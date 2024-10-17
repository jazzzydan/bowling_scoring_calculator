package org.example;

public class Frame {
    private int firstRollPins = -1;
    private int secondRollPins = -1;

    public Frame(int firstRollPins) {
        this.firstRollPins = firstRollPins;
    }

    private int bonus = 0;

    public int getFirstRollPins() {
        return firstRollPins;
    }

    public int getSecondRollPins() {
        return secondRollPins;
    }

    public void setSecondRollPins(int secondRollPins) {
        this.secondRollPins = secondRollPins;
    }

    public int getPins() {
        return Math.max(firstRollPins, 0) + Math.max(secondRollPins, 0);
    }

    public int getScore() {
        return getPins() + bonus;
    }

    public boolean isOpen() {
        return secondRollPins < 0;
    }

    public boolean isSpare() {
        return getPins() == 10;
    }

    public boolean isStrike() {
        return getFirstRollPins() == 10;
    }
}


