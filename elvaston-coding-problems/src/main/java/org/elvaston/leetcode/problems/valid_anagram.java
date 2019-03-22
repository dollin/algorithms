package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.hash_table;
import org.elvaston.leetcode.tags.sort;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
@easy
@hash_table
@sort
public class valid_anagram {
    /**
     * 1. Sort then check equals
     */
    public boolean isAnagramWithSort(String s, String t) {
        return sort(s).equals(sort(t));
    }

    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /**
     * 2. Use a hash table per char, and +1 when in s, -1 when in t.
     *    Then check for non-zero values.
     */
    public boolean isAnagramWithHashTable(String s, String t) {
        if (s.length() != s.length()) {
            return false;
        }
        int[] counts = new int[26]; //26 as only lowercase alphabet, if gets tricky could use a Map instead

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            counts[c - 'a']--;
        }

        for (int i : counts) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
