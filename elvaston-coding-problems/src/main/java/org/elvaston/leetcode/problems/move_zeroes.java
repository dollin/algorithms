package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.array;
import org.elvaston.leetcode.tags.two_pointers;

/**
 * https://leetcode.com/problems/move-zeroes/
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
@array
@two_pointers
@easy
public class move_zeroes {

    /**
     * O(n) time, O(1) space
     * But sub-optimal when array has many zeros.
     */
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int zeroIndex = nums.length;
        for (int i = 0; i < zeroIndex;) {
            if (nums[i] == 0) {
                zeroIndex--;
                for (int j = i; j < zeroIndex; j++) {
                    swap(nums, j, j + 1);
                }
            } else {
                i++;
            }
        }
        print(nums);
    }

    /**
     * O(n) time, O(1) space
     */
    public void moveZeroes1(int[] nums) {
        for (int nonZeroIndex = 0, currIndex = 0; currIndex < nums.length; currIndex++) {
            if (nums[currIndex] != 0) {
                swap(nums, nonZeroIndex, currIndex);
                nonZeroIndex++;
            }
        }
        print(nums);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void print(int[] nums) {
        for (int i : nums) {
            System.out.print(i);
        }
        System.out.println();
    }
}
