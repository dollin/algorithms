package org.elvaston.leetcode.medium;

/**
 * https://leetcode.com/problems/counting-bits/
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of
 * 1's in their binary representation and return them as an array.
 * Example 1:
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 * Input: 5
 * Output: [0,1,1,2,1,2]
 */
public class counting_bits {
    int[] countOnes(int num) {
        int[] ones = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ones[i] = bits(i);
        }
        return ones;
    }

    private int bits(int num) {
        Integer.bitCount(5);
        int ones = 0;
        if (num <= 1) {
            return num;
        }
        while (num > 0) {
            if ((num & 1) == 1) {
                ones++;
            }
            num = num >> 1;
        }
        return ones;
    }

    public static void main(String... args) {
        counting_bits cb = new counting_bits();
        for (int i : cb.countOnes(5)) {
            System.out.println(i);
        }
    }
}
