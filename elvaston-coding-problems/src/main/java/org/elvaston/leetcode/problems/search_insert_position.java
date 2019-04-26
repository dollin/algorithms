package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.array;
import org.elvaston.leetcode.tags.binary_search;

/**
 * https://leetcode.com/problems/search-insert-position/
 *
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 */
@easy
@array
@binary_search
public class search_insert_position {
    public int searchInsert(int[] nums, int target) {
        if (nums[0] > target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        return find(nums, 0, nums.length - 1, target);
    }

    private int find(int[] a, int lo, int hi, int target) {
        if (a[lo] == target) {
            return lo;
        }
        if (a[hi] == target) {
            return hi;
        }
        if (hi - lo <= 1) {
            if (target < a[lo]) {
                return lo;
            }
            return hi;
        }
        if (target >= a[(hi + lo) / 2]) {
            return find(a, (hi + lo) / 2, hi, target);
        }
        return find(a, lo, ((hi + lo) / 2), target);
    }
}
