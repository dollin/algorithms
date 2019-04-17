package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.tags.array;
import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.two_pointers;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Example 1:
 * Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * Given nums = [0,0,1,1,1,1,2,3,3],
 *
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 */
@medium
@array
@two_pointers
public class remove_duplicates_from_sorted_array_ii {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int noToCheck = nums[0];
        int count = 1;
        int length = nums.length;
        int empty = nums[0] - 10;
        for (int i = 1; i < nums.length; i++) {
            if (noToCheck == nums[i]) {
                count++;
            } else {
                count = 1;
                noToCheck = nums[i];
            }
            if (count > 2) {
                nums[i] = empty;
                length--;
            }
        }
        for (int i = 0; i < length; i++) {
            while (nums[i] == empty) {
                for (int j = i + 1; j < nums.length; j++) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return length;
    }
}
