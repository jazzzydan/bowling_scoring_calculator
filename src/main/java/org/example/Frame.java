package org.example;

public class Frame {
    private int firstRollPins = 0;
    private int secondRollPins = 0;
    private int points;
    private boolean isFirstRoll = true;

    public Frame() {

    }

    public int getFirstRollPins() {
        return firstRollPins;
    }

    public void setFirstRollPins(int firstRollPins) {
        this.firstRollPins = firstRollPins;
    }

    public int getSecondRollPins() {
        return secondRollPins;
    }

    public void setSecondRollPins(int secondRollPins) {
        this.secondRollPins = secondRollPins;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isFirstRoll() {
        return isFirstRoll;
    }

    public void setFirstRoll(boolean firstRoll) {
        isFirstRoll = firstRoll;
    }
}


