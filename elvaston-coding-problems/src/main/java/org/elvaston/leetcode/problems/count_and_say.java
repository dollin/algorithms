package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.string;

/**
 * https://leetcode.com/problems/count-and-say/
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Input: 1
 * Output: "1"
 *
 * Input: 4
 * Output: "1211"
 */
@easy
@string
public class count_and_say {
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String asWord  = "1";
        for (int i = 2; i <= n; i++) {
            String newWord = "";
            int count = 0;
            char num = asWord.charAt(0);
            for (char c : asWord.toCharArray()) {
                if (num == c) {
                    count++;
                } else {
                    newWord += count + "" + num;
                    count = 1;
                    num = c;
                }
            }
            newWord += count + "" + num;
            asWord = newWord;
        }
        return asWord;
    }
}
