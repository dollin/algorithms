package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.array;
import org.elvaston.leetcode.tags.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
@easy
@array
@hash_table
public class two_sum {

    /**
     * twoSum using nested for loops O(n^2) complexity
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    /**
     * twoSum using map for O(n) complexity
     */
    public int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }

    /**
     * twoSum using map for O(n) complexity
     */
    public int[] twoSumArray(int[] nums, int target) {
        int[] remainder = new int[target];
        for (int i = 0; i < remainder.length; i++) {
            remainder[i] = 0;
        }
        int[] index = new int[target];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + remainder[target - nums[i]] == target) {
                return new int[]{index[target - nums[i]], i};
            } else {
                remainder[nums[i]] = nums[i];
                index[nums[i]] = i;
            }
        }

        return new int[2];
    }
}
