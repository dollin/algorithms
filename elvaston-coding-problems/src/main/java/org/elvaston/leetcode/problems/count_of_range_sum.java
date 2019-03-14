package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.hard;
import org.elvaston.leetcode.tags.dynamic_programming;

/**
 * https://leetcode.com/problems/count-of-range-sum/
 *
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 *
 * Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * Output: 3
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 */
@hard
@dynamic_programming
public class count_of_range_sum {
    private int countRangeSum(int[] nums, int min, int max) {
        long[] runningTotals = new long[nums.length];
        int count = 0;

        for (int i = 0; i < runningTotals.length; i++) {
            runningTotals[i] = i == 0 ? nums[0] : runningTotals[i-1] + nums[i];
            if (min <= runningTotals[i] && runningTotals[i] <= max) {
                count++;
            }
        }

        for (int j = 1; j < runningTotals.length; j++) {
            for (int i = j; i < runningTotals.length; i++) {
                runningTotals[i] -= runningTotals[j-1];
                if (min <= runningTotals[i] && runningTotals[i] <= max) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        count_of_range_sum solution = new count_of_range_sum();
        System.out.println(solution.countRangeSum(new int[]{-2, -1, 5, -1}, -2, 2));
        System.out.println(solution.countRangeSum(new int[]{Integer.MIN_VALUE, 0, Integer.MIN_VALUE,Integer.MAX_VALUE}, -564, 3864));
    }
}