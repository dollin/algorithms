package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.string;
import org.elvaston.leetcode.tags.two_pointers;

/**
 * https://leetcode.com/problems/implement-strstr/
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
@easy
@string
@two_pointers
class implement_strstr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        char[] needleChars = needle.toCharArray();
        char[] haystackChars = haystack.toCharArray();

        for (int i = 0; i < haystackChars.length - needleChars.length + 1; i++) {
            boolean matched = true;
            for (int j = 0; j < needleChars.length; j++) {
                if (haystackChars[i + j] != needleChars[j]) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                return i;
            }
        }
        return -1;
    }
}