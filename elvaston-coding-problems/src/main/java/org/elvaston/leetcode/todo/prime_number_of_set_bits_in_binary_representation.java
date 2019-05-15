package org.elvaston.leetcode.todo;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.bit_manipulation;

/**
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
 *
 * Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.
 * (Recall that the number of set bits an integer has is the number of 1s present when written in binary.
 * For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)
 *
 * Input: L = 6, R = 10
 * Output: 4
 * Explanation:
 * 6 -> 110 (2 set bits, 2 is prime)
 * 7 -> 111 (3 set bits, 3 is prime)
 * 9 -> 1001 (2 set bits , 2 is prime)
 * 10->1010 (2 set bits , 2 is prime)
 *
 * Input: L = 10, R = 15
 * Output: 5
 * Explanation:
 * 10 -> 1010 (2 set bits, 2 is prime)
 * 11 -> 1011 (3 set bits, 3 is prime)
 * 12 -> 1100 (2 set bits, 2 is prime)
 * 13 -> 1101 (3 set bits, 3 is prime)
 * 14 -> 1110 (3 set bits, 3 is prime)
 * 15 -> 1111 (4 set bits, 4 is not prime)
 *
 * Note:
 * L, R will be integers L <= R in the range [1, 10^6].
 * R - L will be at most 10000.
 */
@easy
@bit_manipulation
 public class prime_number_of_set_bits_in_binary_representation {
    public int countPrimeSetBits(int L, int R) {
        int primes = 0;
        for (int i = L; i <= R; i++) {
            int bits = countBits(i);
            if (isPrime(bits)) {
                primes++;
            }
        }
        return primes;
    }

    private boolean isPrime(int number) {
        if (number == 2 || number == 3) {
            return true;
        }
        if (number <= 1 || number % 2 == 0) {
            return false;
        }
        for (int x = 3; x < number; x++) {
            if (number % x == 0) {
                return false;
            }
        }
        return true;
    }

    private int countBits(int number) {
        int bits = 0;
        while (number > 0) {
            if ((number & 1) == 1) {
                bits++;
            }
            number = number >> 1;
        }
        return bits;
    }
}
