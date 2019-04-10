package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.bit_manipulation;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 *
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 *
 * Example 1:
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * Example 3:
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *
 * Note:
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given
 * as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.
 */
@bit_manipulation
@easy
public class number_of_1_bits {
    public int hammingWeight(int n) {
        int x = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                x++;
            }
            n = n >>> 1;
        }
        return x;
    }

    /**
     * repeated flip the least-significant 1 to a 0 and increment each time
     * 110100 = n
     * 110011 = n-1
     * 110000 = n & n-11
     */
    public int hammingWeight1(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
