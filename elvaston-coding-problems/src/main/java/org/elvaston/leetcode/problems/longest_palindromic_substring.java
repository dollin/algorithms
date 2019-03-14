package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.tags.dynamic_programming;
import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.string;

/**
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
        String largestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                String tmp = s.substring(i, j);
                if (tmp.length() > largestPalindrome.length() && isPalindrome(tmp)) {
                    largestPalindrome = tmp;
                    j = 0; //short circuit
                }
            }
        }
        return largestPalindrome;
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
