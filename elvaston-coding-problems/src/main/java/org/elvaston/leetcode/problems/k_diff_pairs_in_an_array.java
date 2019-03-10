package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.array;
import org.elvaston.leetcode.tags.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 *
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 * Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 *
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 *
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 *
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note:
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 */
@easy
@array
@two_pointers
public class k_diff_pairs_in_an_array {
    public int findPairs(int[] nums, int k) {
        List<Integer> seen = new ArrayList<>();
        Arrays.sort(nums);
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[j] - nums[i]) == k) {
                    if (!(seen.contains(nums[i]) && seen.contains(nums[j]))) {
                        seen.add(nums[i]);
                        seen.add(nums[j]);
                    }
                }
            }
        }
        return seen.size() / 2;
    }

    public static void main(String[] args) {
        System.out.println(new k_diff_pairs_in_an_array().findPairs(new int[]{3, 1, 4, 1, 5}, 2));
    }
}
