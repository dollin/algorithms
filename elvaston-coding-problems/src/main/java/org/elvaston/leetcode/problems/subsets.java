package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.array;
import org.elvaston.leetcode.tags.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
@medium
@array
@backtracking
public class subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result = add(result, nums, 0);
        return result;
    }

    private List<List<Integer>> add(List<List<Integer>> subsets, int[] nums, int i) {
        if (i >= nums.length) {
            return subsets;
        }
        int size = subsets.size();
        for (int j = 0; j < size; j++) {
            List<Integer> new_subset = new ArrayList<>(subsets.get(j));
            new_subset.add(nums[i]);
            subsets.add(new_subset);
        }
        return add(subsets, nums, i + 1);
    }

    public static void main(String[] args) {
        subsets solution = new subsets();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
        System.out.println(solution.subsets(new int[]{1, 2, 3, 4}));
    }
}
