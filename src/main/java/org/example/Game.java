package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    public static void main(String[] args) {
        BowlingScoreCalculator scoreCalculator = new BowlingScoreCalculator();

        List<Integer> rolls = new ArrayList<>(Arrays.asList(5, 4, 10, 2, 8, 7, 3, 10, 10, 0, 9, 2, 5, 3, 6, 2, 3));
//        List<Integer> rolls = new ArrayList<>(Arrays.asList(8, 2, 5, 4, 9, 0, 10, 10, 5, 5, 5, 3, 6, 3, 9, 1, 9, 1, 10));
        List<Integer> frameScore = new ArrayList<>();

        for (int i = 0; i < rolls.size(); i++) {
            scoreCalculator.roll(rolls.get(i));
        }

        System.out.print("\n| ");
        for (int i = 0; i < scoreCalculator.frames.size(); i++) {
            System.out.printf("%-3s", scoreCalculator.frames.get(i).toString());
            System.out.print(" | ");
            frameScore.add(scoreCalculator.getScoreAfterFrame(i, 0));
        }

        System.out.print("\n| ");
        for (int i = 1; i < frameScore.size(); i++) {
            System.out.printf("%-3d", frameScore.get(i));
            System.out.print(" | ");
        }
        System.out.print(scoreCalculator.calculateScore()+"\n");
        System.out.print("Score: " + scoreCalculator.calculateScore()+"\n");
    }
}
