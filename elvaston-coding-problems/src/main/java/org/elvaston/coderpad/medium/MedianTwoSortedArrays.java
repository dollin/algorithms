package org.elvaston.coderpad.medium;

/**
 * Find the median of the two sorted arrays.
 */
public class MedianTwoSortedArrays {

    private static double findMedianSortedArrays(int[] firstArray, int[] secondArray) {
        int[] combinedArray = new int[firstArray.length + secondArray.length];
        int[] indexes = new int[]{0, 0};
        for (int i = 0; i < combinedArray.length; i++) {
            if (firstArray.length <= indexes[0]) {
                combinedArray[i] = secondArray[indexes[1]];
                indexes[1]++;
            } else if (secondArray.length <= indexes[1]) {
                combinedArray[i] = firstArray[indexes[1]];
                indexes[0]++;
            } else if (firstArray[indexes[0]] < secondArray[indexes[1]]) {
                combinedArray[i] = firstArray[indexes[0]];
                indexes[0]++;
            } else {
                combinedArray[i] = secondArray[indexes[1]];
                indexes[1]++;
            }
        }
        return combinedArray.length % 2 == 0
                ? (combinedArray[combinedArray.length / 2] + combinedArray[(combinedArray.length / 2) - 1]) / 2d
                : combinedArray[(combinedArray.length - 1) / 2];
    }

    private static boolean doTestsPass() {
        boolean result = Math.abs(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}) - 2.5) < 0.000001;
        result &= Math.abs(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}) - 2.0) < 0.000001;
        result &= Math.abs(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 6, 8, 10, 34}) - 6.0) < 0.000001;
        return result;
    }

    /**
     * Main entry to implementation.
     * @param args arguments passed into the application.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }
    }
}