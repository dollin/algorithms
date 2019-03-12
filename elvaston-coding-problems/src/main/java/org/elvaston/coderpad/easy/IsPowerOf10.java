package org.elvaston.coderpad.easy;

public class IsPowerOf10 {

    /**
     * returns true if x is a power of 10, false otherwise.
     */
    public static boolean isPowerOf10(int input) {
        return isPowerOf(10, input);
    }

    private static boolean isPowerOf(int powerOf, int input) {
        if (input <= 0) {
            return false;
        }
        while (input > 1) {
            if (input % powerOf != 0) {
                return false;
            }
            input /= powerOf;
        }
        return true;
    }

    private static boolean doTestsPass() {
        int[] isPowerList = {10, 100, 100_000, 1_000_000};
        int[] isNotPowerList = {3, 999, 1_001, 0, 2_000_000};

        for (int i : isPowerList) {
            if (!isPowerOf10(i)) {
                System.out.println("Test failed for " + i);
                return false;
            }
        }

        for (int i : isNotPowerList) {
            if (isPowerOf10(i)) {
                System.out.println("Test failed for " + i);
                return false;
            }
        }
        System.out.println("Tests passed");
        return true;
    }

    private static boolean doPowerOf2TestsPass() {
        int[] isPowerList = {2, 8, 64, 128};
        int[] isNotPowerList = {3, 999, 1_001, 0, 2_000_000};

        for (int i : isPowerList) {
            if (!isPowerOf(2, i)) {
                System.out.println("Test failed for " + i);
                return false;
            }
        }

        for (int i : isNotPowerList) {
            if (isPowerOf(2, i)) {
                System.out.println("Test failed for " + i);
                return false;
            }
        }
        System.out.println("Tests passed");
        return true;
    }

    public static void main(String[] args) {
        doTestsPass();
        doPowerOf2TestsPass();
    }
}
