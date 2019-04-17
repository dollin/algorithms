package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.array;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
@medium
@array
public class product_of_array_except_self {
    public int[] productExceptSelf(int[] nums) {
        int[] rhs = new int[nums.length];
        rhs[rhs.length - 1] = 1;
        for (int i = rhs.length - 2; i >= 0; i--) {
            rhs[i] = nums[i + 1] * (i + 1 >= rhs.length ? 1 : rhs[i + 1]);
        }

        int[] lhs = new int[nums.length];
        lhs[0] = 1;
        for (int i = 1; i < lhs.length; i++) {
            lhs[i] = nums[i - 1] * lhs[i - 1];
        }
        int[] totals = new int[nums.length];
        for (int i = 0; i < totals.length; i++) {
            totals[i] = rhs[i] * lhs[i];
        }
        return totals;
    }
}
