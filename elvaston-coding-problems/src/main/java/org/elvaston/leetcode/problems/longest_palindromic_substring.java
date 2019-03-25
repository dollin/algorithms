package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.tags.dynamic_programming;
import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.string;

/**
 *
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Input: "cbbd"
 * Output: "bb"
 */
@medium
@dynamic_programming
@string
public class longest_palindromic_substring {

    public String longestPalindrome(String s) {
        //sub-string length
        for (int len = s.length(); len >= 0; len--) {
            for (int i = 0; i + len <= s.length() ; i++) {
                String tmp = s.substring(i, len + i);
                if (isPalindrome(tmp)) {
                    return tmp;
                }
                System.out.print(tmp + ",");
            }
            System.out.println();
        }
        return "";
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - (i + 1))) {
                return false;
            }
        }
        return true;
    }
}
