package org.elvaston.coderpad.easy;

public class DotProduct {

    /**
     * Given 2 arrays of integers return the dot product of the array.
     */
    private static int dotProduct(int[] array1, int[] array2) {
        if (array1.length < 2 || array2.length < 2) {
            throw new IllegalArgumentException("unable to perform dot product.");
        }

        return dp(array1) + dp(array2);
    }

    private static int dp(int[] ints) {
        int product = ints[0];
        for (int i = 1; i < ints.length; i++) {
            product *= ints[i];
        }
        return product;
    }

    /**
     * Static method to call the dp method and check the output #junit.
     * @return boolean depending on whether the tests pass
     */
    public static boolean doTestsPass() {
        boolean result = dotProduct(new int[]{1, 2}, new int[]{2, 3}) == 8;
        result &= dotProduct(new int[]{1, 2, 3, 10}, new int[]{2, 3}) == 66;
        result &= dotProduct(new int[]{1, 2}, new int[]{2, 3, -1, 1}) == -4;
        result &= dotProduct(new int[]{1, 2, 2, -2}, new int[]{2, 3, 0}) == -8;

        if (result) {
            System.out.println("Test passed.");
            return true;
        } else {
            System.out.println("Test failed.");
            return false;
        }
    }

    private static void lengthOneTest() {
        try {
            dotProduct(new int[]{1}, new int[]{2, 1});
            System.out.println("Test failed.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test passed.");

        }

        try {
            dotProduct(new int[]{1}, new int[]{2, 1});
            System.out.println("Test failed.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test passed.");

        }

        try {
            dotProduct(new int[]{1, 2}, new int[]{1});
            System.out.println("Test failed.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test passed.");
        }
    }

    public static void main(String[] args) {
        doTestsPass();
        lengthOneTest();
    }
}
