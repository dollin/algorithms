package org.elvaston.coderpad.easy;

public class SecondSmallest {

    /**
     * return the second smallest. If fewer than 2 elements return 0.
     */
    private static double secondSmallest(int[] ints) {

        if (ints.length < 2) {
            return 0;
        } else if (ints.length == 2) {
            return Math.max(ints[0], ints[1]);
        }

        int[] smallest = new int[]{ints[0], ints[1]};
        for (int i = 2; i < ints.length; i++) {
            if (ints[i] < smallest[0] || ints[i] < smallest[1]) {
                if (smallest[0] < smallest[1]) {
                    smallest[1] = ints[i];
                } else {
                    smallest[0] = ints[i];
                }
            }
        }
        return Math.max(smallest[0], smallest[1]);
    }

    private static boolean doTestsPass() {

        boolean result = secondSmallest(new int[]{3}) == 0;
        result &= secondSmallest(new int[]{0, 1}) == 1;
        result &= secondSmallest(new int[]{1, 0}) == 1;
        result &= secondSmallest(new int[]{-1_221, 0, 0, 0, 4_000, 7_000}) == 0;
        result &= secondSmallest(new int[]{1, 3, 7, 9, 4}) == 3;
        result &= secondSmallest(new int[]{1, 3, -7, -9, 4}) == -7;

        if (result) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }
        return result;
    }

    public static void main(String[] args) {
        doTestsPass();
    }
}
