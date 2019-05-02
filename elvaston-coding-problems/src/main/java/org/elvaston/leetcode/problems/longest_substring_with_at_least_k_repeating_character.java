package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.two_pointers;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 *
 * Find the length of the longest substring T of a given string (consists of lowercase letters only)
 * such that every character in T appears no less than k times.
 * Input:
 *   s = "aaabb", k = 3
 * Output:
 * 3
 *
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 *
 * Input:
 * s = "ababbc", k = 2
 * Output:
 * 5
 *
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
@two_pointers
@medium
public class longest_substring_with_at_least_k_repeating_character {

    public int longestSubstring(String s, int k) {
        int[] counts = new int[26]; //a-z
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int longest_substring = 0;
            for (int j = i; j < s.length(); j++) {
                if (counts[s.charAt(j) - 'a'] >= k) {
                    longest_substring++;
                } else {
                    break;
                }
            }
            max = Math.max(max, longest_substring);
        }
        return max;
    }

    public static void main(String[] args) {
        longest_substring_with_at_least_k_repeating_character solution = new longest_substring_with_at_least_k_repeating_character();
        System.out.println("4: " + solution.longestSubstring("ababc", 2));
        System.out.println("5: " + solution.longestSubstring("abbbccaaaaa", 3));
        System.out.println("7: " + solution.longestSubstring("abbbcaabbaaa", 3));
    }
}
