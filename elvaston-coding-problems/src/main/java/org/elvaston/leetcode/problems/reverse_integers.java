package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.math;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/reverse-integer/
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Example 1:
 * Input: 123
 * Output: 321
 * Example 2:
 * Input: -123
 * Output: -321
 * Example 3:
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
@easy
@math
public class reverse_integers {
    public int reverse(int x) {
        Queue<Integer> queue = new LinkedList<>();

        int sign = x < 0 ? -1 : 1;
        int unsignedX = sign * x;
        while (unsignedX > 0) {
            queue.add(unsignedX % 10);
            unsignedX /= 10;
        }

        long reversedNumber = 0;
        while (!queue.isEmpty()) {
            reversedNumber = (reversedNumber * 10) + queue.remove();
        }
        if (reversedNumber > Integer.MAX_VALUE) {
            return 0;
        }
        return sign * (int) reversedNumber;
    }

    public int reverse_without_long(int x) {
        boolean isneg = x < 0 ? true : false;
        int rev = 0;
        while (x != 0) {
            System.out.println(rev);
            int mod = Math.abs(x % 10);
            if (rev > Integer.MAX_VALUE / 10 ||
                    (rev == Integer.MAX_VALUE / 10 && mod > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            rev *= 10;
            rev += mod;
            x /= 10;
        }
        return isneg ? -1 * rev : rev;
    }
}