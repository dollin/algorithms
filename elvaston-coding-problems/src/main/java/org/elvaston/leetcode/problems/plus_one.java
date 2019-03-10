package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.array;

/**
 * https://leetcode.com/problems/plus-one/
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
@easy
@array
public class plus_one {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + carry;
            if (digits[i] >= 10) {
                carry = digits[i] / 10;
                digits[i] = digits[i] % 10;
            } else {
                carry = 0;
            }
        }
        if (carry > 0) {
            int[] extendedDigits = new int[digits.length + 1];
            for (int i = digits.length - 1; i >= 0; i--) {
                extendedDigits[i + 1] = digits[i];
            }
            extendedDigits[0] = 1;
            return extendedDigits;
        }
        return digits;
    }
}
