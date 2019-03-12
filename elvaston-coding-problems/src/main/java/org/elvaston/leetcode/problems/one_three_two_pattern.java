package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.array;

/**
 * https://leetcode.com/problems/132-pattern/
 *
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj.
 * Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 * Note: n will be less than 15,000.
 */
@medium
@array
public class one_three_two_pattern {
    public boolean find132pattern(int[] nums) {
        int i_min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            i_min = Math.min(i_min, nums[i]);
            for (int k = i + 1; k < nums.length; k++) {
                if (i_min < nums[k] && nums[i] > nums[k]) {
                    return true;
                }
            }
        }
        return false;
    }
}
