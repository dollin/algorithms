package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.tags.math;
import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.string;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/string-to-integer-atoi
 *
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * If the numerical value is out of the range of representable values, INT_MAX (2^31 − 1) or INT_MIN (−2^31) is returned.
 *
 * Input: "42"
 * Output: 42
 *
 *
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 *
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Therefore INT_MIN (−2^31) is returned.
 */
@medium
@math
@string
public class string_to_integer_atoi {
    public int myAtoi(String str) {

        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        char[] chars = str.trim().toCharArray();
        int i = 0;

        int mult = chars[0] == '-' ? -1 : 1;

        if (isDigit(chars[0])) {
            i = chars[0] - '0';
        } else if (chars[0] != '-' && chars[0] != '+') {
            return 0;
        }


        int index = 1;
        while(index < chars.length && isDigit(chars[index])) {
            //OVERFLOW
            if (mult == 1 && maxOverflow(i, chars[index])) {
                return Integer.MAX_VALUE;
            } else if (mult == -1 && minOverflow(i, chars[index]))  {
                return Integer.MIN_VALUE;
            }
            i *= 10;
            i += (chars[index++] - '0');
        }
        return mult * i;
    }

    private boolean minOverflow(int i, char aChar) {
        return i > Integer.MAX_VALUE / 10 || (i == Integer.MAX_VALUE / 10 && (aChar - '0') > -1 * (Integer.MIN_VALUE % 10));
    }

    private boolean maxOverflow(int i, char aChar) {
        return i > Integer.MAX_VALUE / 10 || (i == Integer.MAX_VALUE / 10 && (aChar - '0') > Integer.MAX_VALUE % 10);
    }

    private boolean isDigit(char aChar) {
        return aChar >= '0' && aChar <= '9';
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        string_to_integer_atoi solution = new string_to_integer_atoi();
        System.out.println(solution.myAtoi("-2147483649"));
        System.out.println(solution.myAtoi("-2147483648"));
        System.out.println(solution.myAtoi("-2147483647"));
        System.out.println(solution.myAtoi("2147483647"));
        System.out.println(solution.myAtoi("2147483646"));
        System.out.println(solution.myAtoi("2147483648"));
        System.out.println(solution.myAtoi("2147483649"));
    }
}
