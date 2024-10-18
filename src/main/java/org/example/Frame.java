package org.example;

public class Frame {
    final private int firstRollPins;
    private int secondRollPins = -1;

    public Frame(int firstRollPins) {
        this.firstRollPins = firstRollPins;
    }

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
        return getPins();
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

    @Override
    public String toString() {
        String frameResult = "";
        if (isStrike()) {
            frameResult = "X -";
        }
        else if (isSpare()) {
            frameResult = firstRollPins + " /";
        }
        else {
            frameResult = firstRollPins + " " + secondRollPins;
        }
        return frameResult;
    }

    public String toString(int frameNr) {
        String frameResult = "";
        int limit = 8;
        if (isStrike() && frameNr > limit) {
            frameResult = "X";
        } else if (isStrike()) {
            frameResult = "X -";
        }
        else if (isSpare()) {
            frameResult = firstRollPins + " /";
        }
        else if (frameNr > limit+1) {
            frameResult = firstRollPins + " ";
        }
        else {
            frameResult = firstRollPins + " " + secondRollPins;
        }
        return frameResult;
    }
}


