package org.elvaston.coderpad.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueTuples {

    private static Set<String> uniqueTuples(String input, int length) throws IllegalArgumentException {
        if (input == null || input.length() < length) {
            throw new IllegalArgumentException("not big enough");
        }
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < input.length() - length + 1; i++) {
            result.add(input.substring(i, i + length));
        }
        return result;
    }

    private static boolean doTestsPass(String input,
                                       int length,
                                       int expectedSize,
                                       String... expectedTuples) throws IllegalArgumentException {
        Set<String> result = uniqueTuples(input, length);
        if (result.size() == expectedSize) {
            for (String expectedTuple : expectedTuples) {
                if (result.contains(expectedTuple)) {
                    System.out.println("Test passed");
                } else {
                    System.out.println("Failed: contains() - " + expectedTuple);
                    return false;
                }
            }
            return true;
        } else {
            System.out.println("Failed: size() - " + result.size() + "!=" + expectedSize + "[" + result + "]");
            return false;
        }
    }

    /**
     * main method to trigger tests.
     * @param args probably empty for the time being
     */
    public static void main(String[] args) {
        doTestsPass("aab", 2, 2, "aa", "ab");
        doTestsPass("aabc", 2, 3, "aa", "ab", "bc");
        doTestsPass("aabcaa", 2, 4, "aa", "ab", "bc", "ca");
        doTestsPass("aabcaab", 3, 4, "aab", "abc", "bca", "caa");
        doTestsPass("aabcaaB", 3, 5, "aab", "abc", "bca", "caa", "aaB");
        try {
            doTestsPass("a", 2, 3, "aa", "ab", "bc");
            System.out.println("Failed: dodgy ask");
        } catch (IllegalArgumentException e) {
            System.out.println("Test passed");
        }
    }
}
