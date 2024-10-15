package org.example;


public class BowlingScoreCalculator {

    private Frame frame = new Frame();
    private int totalPoints;

    public void roll(int pins) {

        if (frame.isFirstRoll()) {
            frame.setFirstRollPins(pins);
            frame.setPoints(pins);
            frame.setFirstRoll(false);
        } else {
            frame.setSecondRollPins(pins);
            frame.setPoints(frame.getFirstRollPins() + pins);
        }
    }

    public int score() {
        return frame.getPoints();
    }
}