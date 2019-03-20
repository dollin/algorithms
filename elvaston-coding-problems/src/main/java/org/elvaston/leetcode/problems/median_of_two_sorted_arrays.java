package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.hard;
import org.elvaston.leetcode.tags.array;
import org.elvaston.leetcode.tags.binary_search;
import org.elvaston.leetcode.tags.divide_and_conquer;
import org.elvaston.leetcode.tags.two_pointers;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
@hard
@array
@binary_search
@divide_and_conquer
@two_pointers
public class median_of_two_sorted_arrays {
    public double median(int[] a, int[] b) {
        int len = a.length + b.length;
        int aIndex = 0;
        int bIndex = 0;
        boolean isEven = len % 2 == 0;
        int[] median = new int[]{0, 0};
        for (; aIndex + bIndex <= len / 2;) {
            if (b.length == 0 || bIndex >= b.length || (aIndex < a.length && a[aIndex] <= b[bIndex])) {
                aIndex = set(a, aIndex, isEven, median);
            } else {
                bIndex = set(b, bIndex, isEven, median);
            }
        }
        return (median[0] + median[1]) / 2.0;
    }

    private int set(int[] nums, int index, boolean pair, int[] median) {
        int tmp = median[1];
        median[1] = nums[index];
        median[0] = pair ? tmp : median[1];
        return index + 1;
    }

    public static void main(String[] args) {
        median_of_two_sorted_arrays solution = new median_of_two_sorted_arrays();
        System.out.println("2.0 = " + solution.median(new int[]{2}, new int[]{1,3}));
        System.out.println("2.0 = " + solution.median(new int[]{}, new int[]{2}));
        System.out.println("1.0 = " + solution.median(new int[]{1}, new int[]{1}));
        System.out.println("2.5 = " + solution.median(new int[]{1, 2}, new int[]{3, 4}));
    }
}
