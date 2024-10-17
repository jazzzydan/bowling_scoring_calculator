package org.example;

import java.util.ArrayList;
import java.util.List;

public class BowlingScoreCalculator {

    ArrayList<Frame> frames = new ArrayList<>();

    public void roll(int pins) {
        Frame frame = frames.isEmpty() ? null : frames.get(frames.size() - 1);

        if (frame != null && frame.isOpen()) {
            frame.setSecondRollPins(pins);
        } else {
            frames.add(frame = new Frame(pins));
            if (pins == 10) {
                frames.get(frames.size() - 1).setSecondRollPins(0);
            }
        }
    }

    public int calculateScore() {

        int totalScore = 0;
        for (int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);
            totalScore += frame.getScore();

            if (frame.isStrike() && frames.size() > (i + 1)) {
                totalScore += getStrikeBonus(i);
            } else if (frame.isSpare() && frames.size() > (i + 1)) {
                totalScore += getSpareBonus(i);
            }
        }
        return totalScore;

//        return frames.stream()
//                .mapToInt(frame -> frame.getScore())
//                .sum();
    }

    private int getSpareBonus(int frameIndex) {
        if (frameIndex < 9) {
            var nextFrame = frames.get(frameIndex + 1);
            return nextFrame.getFirstRollPins();
        }
        return 0;
    }

    private int getStrikeBonus(int frameIndex) {
        if (frameIndex < 9) {
            var nextFrame = frames.get(frameIndex + 1);
            int bonus = nextFrame.getFirstRollPins() + nextFrame.getSecondRollPins();

            if (nextFrame.isStrike() && frames.size() > (frameIndex + 2)) {
                bonus += frames.get(frameIndex + 2).getFirstRollPins();
            }
            return bonus;
        }
        return 0;
    }
}