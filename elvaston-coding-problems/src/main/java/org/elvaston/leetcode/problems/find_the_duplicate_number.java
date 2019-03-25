package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.tags.array;
import org.elvaston.leetcode.tags.binary_search;
import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.two_pointers;

/**
 * https://leetcode.com/problems/find-the-duplicate-number
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * 3242
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n^2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
@medium
@array
@binary_search
@two_pointers
public class find_the_duplicate_number {

    public int findDuplicate(int[] nums) {
        int tort = nums[0];
        int hare = nums[0];

        //find index where the 2 runners intersect
        do {
            tort = nums[tort];
            hare = nums[nums[hare]];
        } while (tort != hare);

        //now run from 0 the above index checking for
        int first = nums[0];
        int second = tort;
        while (first != second) {
            first = nums[first];
            second = nums[second];
        }
        return first;
    }
}
