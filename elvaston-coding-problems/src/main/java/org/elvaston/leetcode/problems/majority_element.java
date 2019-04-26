package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.tags.array;
import org.elvaston.leetcode.difficulty.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Input: [3,2,3]
 * Output: 3
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
@easy
@array
public class majority_element {

    /**
     * Using sort then return the mid since the majority element now occupies over 1/2 the indexes so has to
     * go through the midpoint.
     * O(n log n)
     */
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * O(n)
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i: nums) {
            counter.putIfAbsent(i, 0);
            counter.computeIfPresent(i, (k, count) -> count + 1);
            if (counter.get(i) > nums.length / 2) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,1,1,2,2,2,2,1,1,1}));
        System.out.println(majorityElement1(new int[]{1,1,1,2,2,2,2,1,1,1}));
        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement(new int[]{3,2,2,3,3}));
        System.out.println(majorityElement1(new int[]{3,2,3}));
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
