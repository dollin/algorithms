package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.math;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/palindrome-number/
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * Example 1:
 * Input: 121
 * Output: true
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * Could you solve it without converting the integer to a string?
 */
@easy
@math
public class palindrome_number {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        int reversedInt = x;
        while (reversedInt > 0) {
            queue.add(reversedInt % 10);
            reversedInt /= 10;
        }
        reversedInt = queue.remove();
        while (!queue.isEmpty()) {
            reversedInt = reversedInt * 10 + queue.remove();
        }
        return reversedInt == x;
    }
}
