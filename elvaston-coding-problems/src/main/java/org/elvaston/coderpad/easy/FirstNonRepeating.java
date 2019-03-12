package org.elvaston.coderpad.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {

    /**
     * Find the first non-repeating character in an input string.
     */
    private static char findFirst(String input) {
        char[] inputArray = input.toCharArray();
        for (int i = 0; i < inputArray.length; i++) {
            boolean hasRepeat = false;
            for (int j = 0; j < inputArray.length; j++) {
                if (i != j && inputArray[i] == inputArray[j]) {
                    hasRepeat = true;
                }
            }
            if (!hasRepeat) {
                return inputArray[i];
            }

        }
        throw new RuntimeException("nope");
    }

    private static char findFirst1(String input) {
        Map<Character, Integer> counters = new HashMap<>();
        for (char c : input.toCharArray()) {
            int count = counters.get(c) == null ? 1 : counters.get(c) + 1;
            counters.put(c, count);
        }
        for (char c : input.toCharArray()) {
            if (counters.get(c) == 1) {
                return c;
            }
        }
        throw new RuntimeException("nope");
    }

    private static boolean doTestsPass() {
        String[] inputs = {"apple", "ppl", "racecars", "ababdc"};
        char[] outputs = {'a', 'l', 'e', 'd'};
        boolean result = true;
        for (int i = 0; i < inputs.length; i++) {
            result = result && findFirst(inputs[i]) == outputs[i];
            result = result && findFirst1(inputs[i]) == outputs[i];
            if (!result) {
                System.out.println("Test failed.");
            } else {
                System.out.println("Test passed.");
            }
        }
        return (result);
    }

    public static void main(String[] args) {
        doTestsPass();
    }
}
