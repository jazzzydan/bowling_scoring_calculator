package org.example;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    List<Frame> frames = new ArrayList<>();

    public void roll(int pins) {
        var frame = frames.isEmpty() ? null : frames.getLast();

        if (frame != null && frame.isOpen()) {
            frame.setSecondRollPins(pins);
        } else {
            frames.add(new Frame(pins));
            if (frames.getLast().isStrike()) {
                frames.getLast().setSecondRollPins(0);
            }
        }
    }

    public int calculateScore() {
        int totalScore = 0;
        return getScoreAfterFrame(frames.size(), totalScore);
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

    public int getScoreAfterFrame(int frameNumber, int totalScore) {
        for (int i = 0; i < frameNumber; i++) {
            Frame frame = frames.get(i);
            totalScore += frame.getScore();

            if (frame.isStrike() && frames.size() > (i + 1)) {
                totalScore += getStrikeBonus(i);
            } else if (frame.isSpare() && frames.size() > (i + 1)) {
                totalScore += getSpareBonus(i);
            }
        }
        return totalScore;
    }

    @Override
    public String toString() {
        List<Integer> frameScore = new ArrayList<>();
        StringBuilder scoreBoard = new StringBuilder("| ");

        for (int i = 0; i < frames.size(); i++) {
            if (i < 9) {
                scoreBoard.append(frames.get(i).toString()).append(" | ");
            } else {
                scoreBoard.append(frames.get(i).toString(i));
            }
            frameScore.add(getScoreAfterFrame(i, 0));
        }
        scoreBoard.append("|");
        frameScore.add(getScoreAfterFrame(frames.size(), 0));

        scoreBoard.append("\n| ");
        for (int i = 1; i < frameScore.size(); i++) {
            if (i < 10) {
                scoreBoard.append(String.format("%-3s",frameScore.get(i))).append(" | ");
            } else if (i == 10) {
                scoreBoard.append(calculateScore());
            }
        }
        scoreBoard.append("\nScore: ").append(calculateScore()).append("\n");

        return scoreBoard.toString();
    }
}
