package org.example;


import java.util.ArrayList;
import java.util.List;

public class BowlingScoreCalculator {
    Frame frame = new Frame();
    List<Frame> frames = new ArrayList<>();

    public void roll(int pins) {
//        var frame = frames.getLast();
        if (frame.isFirstRoll()) {
            frame.setFirstRollPins(pins);
            checkPreviousFrameHasSpare(pins);
        } else {
            frame.setSecondRollPins(pins);
            frames.add(frame);
            frame = new Frame();
        }
    }

    private void checkPreviousFrameHasSpare(int pins) {
        if (!frames.isEmpty()) {
            var prevFrame = frames.get(frames.size() - 1);
            if (prevFrame.isSpare()) {
                prevFrame.setBonus(pins);
            }
        }
    }

    public int score() {

        return frames.stream()
                .mapToInt(frame -> frame.getScore())
                .sum();
    }
}