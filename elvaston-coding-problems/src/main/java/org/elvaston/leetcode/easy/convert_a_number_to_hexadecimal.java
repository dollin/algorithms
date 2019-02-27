package org.elvaston.leetcode.easy;

/**
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * Note:
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero
 * character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 *
 * Example 1:
 * Input:
 * 26
 *
 * Output:
 * "1a"
 *
 * Example 2:
 * Input:
 * -1
 *
 * Output:
 * "ffffffff"
 */
public class convert_a_number_to_hexadecimal {
    public String toHex(int i) {
        if (i == 0) {
            return "0";
        }
        String hex = "";
        while (i != 0) {
            int rem = (i % 16) & 15;
            hex = (rem > 9 ? (char) ('a' - 10 + rem) + "" : rem + "") + hex;
            i = i >>> 4; //divide by 2^4 (16)
        }
        return hex;
    }
}
