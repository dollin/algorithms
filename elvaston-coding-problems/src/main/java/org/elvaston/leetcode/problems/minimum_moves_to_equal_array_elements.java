package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.math;

/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 *
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing n - 1 elements by 1.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 3
 *
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 *
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
@easy
@math
public class minimum_moves_to_equal_array_elements {

    /**
     * Need to think the other way around. Rather than +1 to n-1. Same as -1 to 1.
     * And since solution is +1 to all apart from the max during each iteration. It's the same as
     * -1 to each one other than the min, so we can just sum the diff between val and min for all apart from the designated min
     */
    public int minMoves(int[] nums) {
        int counter = 0;
        int minIndex = minIndex(nums);
        int minVal = nums[minIndex];

        for (int i = 0; i < nums.length; i++) {
            if (i != minIndex) {
                counter += (nums[i] - minVal);
            }
        }

        return counter;
    }

    private int minIndex(int[] nums) {
        int val = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val > nums[i]) {
                val = nums[i];
                index = i;
            }
        }
        return index;
    }
}
