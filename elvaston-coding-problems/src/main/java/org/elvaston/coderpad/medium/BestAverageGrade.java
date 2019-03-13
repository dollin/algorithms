package org.elvaston.coderpad.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the best average test score. Return an integer and use a floor function to
 * return the largest integer less than or equal to the average.
 * Return 0 for an empty input.
 */
public class BestAverageGrade {

    private static Integer bestAverageGrade(String[][] scores) {
        Map<String, Integer> averageScores = new HashMap<>();
        for (int x = 0; x < scores.length; x++) {
            String key = scores[x][0];
            Integer value = Integer.valueOf(scores[x][1]);
            averageScores.putIfAbsent(key, value);
            averageScores.computeIfPresent(key, (name, score) -> (int) Math.floor((value + score) / 2));
        }
        int max = 0;
        for (Integer value: averageScores.values()) {
            max = Math.max(max, value);
        }
        return max;
    }

    private static boolean doTestsPass() {
        String[][] tc1 = { {"Bobby", "87" },
            {"Charles", "100"},
            {"Eric", "64"},
            {"Charles", "22"}};

        return bestAverageGrade(tc1) == 87;
    }

    /**
     * Entry main method.
     * @param args probably empty
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }
    }
}