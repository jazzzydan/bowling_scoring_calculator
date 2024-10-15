package org.example;

public class Frame {
    private int firstRollPins = -1;
    private int secondRollPins = -1;
    private int bonus = 0;

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

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getPins() {
        return Math.max(firstRollPins, 0) + Math.max(secondRollPins, 0);
    }

    public int getScore() {
        return getPins() + bonus;
    }

    public boolean isFirstRoll() {
        return firstRollPins < 0;
    }

    public boolean isSpare() {
        return getPins() == 10;
    }

    public boolean isStrike() {
        return getFirstRollPins() == 10;
    }
}


