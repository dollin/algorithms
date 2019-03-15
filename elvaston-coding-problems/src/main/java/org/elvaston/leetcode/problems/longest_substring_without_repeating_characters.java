package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
@medium
@array
public class longest_substring_without_repeating_characters {

    /**
     * Using a set to keep track of the substring, but could also use an array[26], [128] (for ASCII) or a HashMap<char, int>
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> substring = new HashSet<>();
        int i = 0;
        int j = 0;
        int ans = Integer.MIN_VALUE;
        while (i < s.length() && j < s.length()) {
            if (!substring.contains(s.charAt(j))) {
                substring.add(s.charAt(j++));
                ans = Math.max(j - i, ans);
            } else {
                substring.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
