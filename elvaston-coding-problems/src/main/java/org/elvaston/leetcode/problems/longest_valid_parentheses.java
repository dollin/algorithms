package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.hard;
import org.elvaston.leetcode.tags.string;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * Example 1:
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
@hard
@string
public class longest_valid_parentheses {

    public int longestValidParentheses(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int maxLevel = 0;
            int level = 0;
            int counter = 0;
            for (int j = i; j < s.length(); j++) {
                if (level < 0) {
                    break;
                } else if (s.charAt(j) == '(') {
                    counter++;
                    level++;
                } else if (s.charAt(j) == ')') {
                    counter++;
                    level--;
                }
                if (level == 0) {
                    maxLevel += counter;
                    counter = 0;
                }
            }
            max = Math.max(max, maxLevel);
        }
        return max;
    }
}
