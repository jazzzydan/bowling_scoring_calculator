package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    public static void main(String[] args) {
        BowlingScoreCalculator scoreCalculator = new BowlingScoreCalculator();

//        List<Integer> rolls = new ArrayList<>(Arrays.asList(5,4,10,2,8,7,3,10,10,0,9,2,5,3,6,2,3));
//        List<Integer> rolls = new ArrayList<>(Arrays.asList(10,10,10,10,10,10,10,10,10,10,10,10));
        List<Integer> rolls = new ArrayList<>(Arrays.asList(8,2,5,4,9,0,10,10,5,5,5,3,6,3,9,1,9,1,10));


        List<Integer> frameScore = new ArrayList<>();

        for (int i = 0; i < rolls.size(); i++) {
            scoreCalculator.roll(rolls.get(i));
        }

        System.out.print("\n| ");
        for (int i = 0; i < scoreCalculator.frames.size(); i++) {

            if (i < 9) {
                System.out.printf("%-3s", scoreCalculator.frames.get(i).toString());
                System.out.print(" | ");
            } else {
                System.out.printf("%-1s ", scoreCalculator.frames.get(i).toString(i));
            }
            frameScore.add(scoreCalculator.getScoreAfterFrame(i, 0));
        }
        System.out.print("|");
        frameScore.add(scoreCalculator.getScoreAfterFrame(scoreCalculator.frames.size(), 0));

        System.out.print("\n| ");
        for (int i = 1; i < frameScore.size(); i++) {

            if (i < 10) {
                System.out.printf("%-3d", frameScore.get(i));
                System.out.print(" | ");
            } else if (i == 10) {
                System.out.printf("%-6s", scoreCalculator.calculateScore());
            }

        }
        System.out.print("\nScore: " + scoreCalculator.calculateScore() + "\n");
    }
}
