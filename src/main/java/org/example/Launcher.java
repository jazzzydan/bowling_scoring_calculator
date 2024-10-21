package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Launcher {

    public static void main(String[] args) {
        var scoreCalculator = new BowlingGame();

        List<Integer> rolls = generateRandomRolls();

        for (Integer roll : rolls) {
            scoreCalculator.roll(roll);
        }
        System.out.println(scoreCalculator);
    }

    public static List<Integer> generateRandomRolls() {
        List<Integer> randomRolls = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int roll1 = rand.nextInt(11);
            randomRolls.add(roll1);
            if (roll1 != 10) {
                int roll2 = rand.nextInt(11 - roll1);
                randomRolls.add(roll2);
            }
        }

        if (randomRolls.getLast() == 10) {
            int roll1 = rand.nextInt(11);
            randomRolls.add(roll1);
            int roll2;
            if (roll1 != 10) {
                roll2 = rand.nextInt(11 - roll1);
            } else {
                roll2 = rand.nextInt(11);
            }
            randomRolls.add(roll2);
        } else if (randomRolls.getLast() + randomRolls.get(randomRolls.size() - 2) == 10) {
            int roll1 = rand.nextInt(11);
            randomRolls.add(roll1);
        }
        return randomRolls;
    }
}
