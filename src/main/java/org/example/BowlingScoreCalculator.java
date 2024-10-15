package org.example;

import java.util.ArrayList;
import java.util.List;

public class BowlingScoreCalculator {
    Frame frame = new Frame();
    List<Frame> frames = new ArrayList<>();

    public void roll(int pins) {

        if (pins == 10) {
            frame.setFirstRollPins(pins);
            frame.setSecondRollPins(0);
            addBonusIfStrike();
            //todo: set check for last frame
            frames.add(frame);
            frame = new Frame();
        } else if (frame.isFirstRoll()) {
            frame.setFirstRollPins(pins);
            addBonusToPreviousIfSpare(pins);
        } else {
            frame.setSecondRollPins(pins);
            addBonusIfStrike();
            frames.add(frame);
            frame = new Frame();
        }
    }

    private void addBonusToPreviousIfSpare(int pins) {
        if (!frames.isEmpty()) {
            var prevFrame = frames.get(frames.size() - 1);
            if (prevFrame.isSpare()) {
                prevFrame.setBonus(pins);
            }
        }
    }

    private void addBonusIfStrike() {
        if (frames.size() > 1) {
            var prevFrame = frames.get(frames.size() - 1);
            var oneBeforePreviousFrame = frames.get(frames.size() - 2);
            if (prevFrame.isStrike()) {
                prevFrame.setBonus(frame.getScore());
                oneBeforePreviousFrame.setBonus(frame.getScore() + frame.getScore());
            }
        } else if (frames.size() > 0) {
            var prevFrame = frames.get(frames.size() - 1);
            if (prevFrame.isStrike()) {
                prevFrame.setBonus(frame.getFirstRollPins() + frame.getSecondRollPins());
            }
        }
    }

    public int score() {

        return frames.stream()
                .mapToInt(frame -> frame.getScore())
                .sum();
    }
}