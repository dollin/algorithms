package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.math;
import org.elvaston.leetcode.tags.string;

/**
 * https://leetcode.com/problems/add-binary/
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
@easy
@math
@string
public class add_binary {
    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        String sum = "";
        boolean carry = false;
        for (; aIndex >= 0 || bIndex >= 0; aIndex--, bIndex--) {
            char aChar = aIndex >= 0 ? a.charAt(aIndex) : '0';
            char bChar = bIndex >= 0 ? b.charAt(bIndex) : '0';
            if (aChar == '1' && bChar == '1') {
                sum = carry ? "1" + sum : "0" + sum;
                carry = true;
            } else if (aChar == '1' || bChar == '1') {
                sum = carry ? "0" + sum : "1" + sum;
            } else {
                sum = carry ? "1" + sum : "0" + sum;
                carry = false;
            }
        }
        if (carry) {
            sum = "1" + sum;
        }
        return sum;
    }
}
