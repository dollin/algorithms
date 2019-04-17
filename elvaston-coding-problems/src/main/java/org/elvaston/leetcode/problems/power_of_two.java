package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.tags.bit_manipulation;
import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.math;

/**
 * https://leetcode.com/problems/power-of-two/
 *
 * Given an integer, determine if it is a power of two.
 */
@easy
@bit_manipulation
@math
public class power_of_two {
    public boolean isPowerOfTwo(int n) {
        if (n <=  0) {
            return false;
        }

        /*
         * n  =8 = 1000
         * n-1=7 = 0111
         * &     = 0000 so a power of 2.
         */
        return (n & (n - 1)) == 0;
    }
}
