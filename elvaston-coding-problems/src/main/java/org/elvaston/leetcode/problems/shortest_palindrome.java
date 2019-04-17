package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.hard;
import org.elvaston.leetcode.tags.string;

/**
 * https://leetcode.com/problems/shortest-palindrome/
 *
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 *
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 *
 * Input: "abcd"
 * Output: "dcbabcd"
 */
@hard
@string
public class shortest_palindrome {
    public String shortestPalindrome(String s) {
        String longest = "";
        for (int i = 1; i < s.length(); i++) {
            String tmp = s.substring(0, i);
            if (isPalindrome(tmp)) {
                longest = tmp;
            }
        }
        return reverse(s.substring(longest.length())) + s;
    }

    private String reverse(String s) {
        char[] reverse = new char[s.length()];
        for(int i = 0; i < s.length(); i++) {
            reverse[i] = s.charAt(s.length() - i - 1);
        }
        return new String(reverse);
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - (i + 1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new shortest_palindrome().shortestPalindrome("abcd"));
        System.out.println(new shortest_palindrome().shortestPalindrome("abacdca"));
        System.out.println(new shortest_palindrome().shortestPalindrome("aadaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaacecaaa"));
    }
}
