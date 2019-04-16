package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.tags.array;
import org.elvaston.leetcode.difficulty.easy;

/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
@easy
@array
public class maximum_subarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int imax = Integer.MIN_VALUE;
            int jmax = 0;
            for (int j = i; j < nums.length; j++) {
                jmax += nums[j];
                if (jmax >= imax) {
                    imax = jmax;
                }
            }
            if (imax > max) {
                max = imax;
            }
        }
        return max;
    }
}