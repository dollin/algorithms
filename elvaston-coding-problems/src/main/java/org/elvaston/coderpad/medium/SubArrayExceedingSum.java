package org.elvaston.coderpad.medium;

import java.util.Arrays;

/**
 * Given an array of non-negative numbers and an Integer return the length of the
 * shortest subarray whose sum is at least the integer otherwise return -1.
 */
public class SubArrayExceedingSum {

    private static int subArrayExceedsSumWithSort(int[] arr, int target) {
        int[] arrayToCheck = arr.clone();
        Arrays.sort(arrayToCheck);
        int sum = 0;
        int count = 0;
        for (int i = arrayToCheck.length - 1; i > 0; i--) {
            sum += arrayToCheck[i];
            count++;
            if (sum >= target) {
                return count;
            }
        }
        return -1;
    }

    private static int subArrayExceedsSum(int[] arr, int target) {
        int[] arrayToCheck = arr.clone();
        int sum = 0;
        for (int i = 0; i < arrayToCheck.length; i++) {
            int max = 0;
            int index = 0;
            for (int j = 0; j < arrayToCheck.length; j++) {
                if (max < arrayToCheck[j]) {
                    max = arrayToCheck[j];
                    index = j;
                }
            }
            arrayToCheck[index] = 0;
            sum += max;
            if (sum >= target) {
                return i + 1;
            }
        }
        return -1;
    }

    private static void doTestsPass() {
        int[] arr = {4, 1, 2, 3};
        boolean result = subArrayExceedsSum(arr, 6) == 2;
        result &= subArrayExceedsSum(arr, 12) == -1;
        result &= subArrayExceedsSumWithSort(arr, 6) == 2;
        result &= subArrayExceedsSumWithSort(arr, 12) == -1;

        if (result) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }
    }

    /**
     * Entry main method.
     * @param args probably empty
     */
    public static void main(String[] args) {
        doTestsPass();
    }
}