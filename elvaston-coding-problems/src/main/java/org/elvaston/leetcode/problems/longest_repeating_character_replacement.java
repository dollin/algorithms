package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.array;
import org.elvaston.leetcode.tags.two_pointers;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times.
 * Find the length of a longest substring containing all repeating letters you can get after performing the above operations.
 *
 * Note:
 * Both the string's length and k will not exceed 10^4.
 *
 * Input:
 * s = "ABAB", k = 2
 * Output: 4
 *
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 *
 * Input:
 * s = "AABABBA", k = 1
 * Output: 4
 *
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 */
@medium
@array
@two_pointers
public class longest_repeating_character_replacement {
    public int characterReplacement(String s, int k) {
        int longest = 0;
        int[] charCount = new int[26];
        int j = 0;
        int i = 0;
        while (j < s.length()) {
            charCount[s.charAt(j) - 'A']++;
            if (!isValid(charCount, k)) {
                charCount[s.charAt(i) - 'A']--;
                i++;
            }
            longest = Math.max(longest, length(charCount));
            j++;
        }
        return longest;
    }

    private int length(int[] charCount) {
        int sum = 0;
        for (int i : charCount) {
            sum += i;
        }
        return sum;
    }

    private boolean isValid(int[] charCount, int k) {
        int sum = 0;
        int max = 0;
        for (int i : charCount) {
            sum += i;
            max = Math.max(max, i);
        }
        return sum - max <= k;
    }

    public static void main(String[] args) {
        longest_repeating_character_replacement solution = new longest_repeating_character_replacement();
        System.out.println("5 = " + solution.characterReplacement("AABABBBA", 1));
        System.out.println("4 = " + solution.characterReplacement("ABBB", 2));
        System.out.println("4 = " + solution.characterReplacement("ABBBA", 1));
    }
}
