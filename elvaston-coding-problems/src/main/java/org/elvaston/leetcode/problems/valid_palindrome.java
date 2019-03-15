package org.elvaston.leetcode.problems;

/**
 * https://leetcode.com/problems/valid-palindrome/
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */
public class valid_palindrome {
    public boolean isPalindrome(String s) {
        String lowerS = s.toLowerCase();
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        while(leftIndex < rightIndex) {
            char leftChar = lowerS.charAt(leftIndex);
            char rightChar = lowerS.charAt(rightIndex);
            if (leftChar < 'a' || leftChar > 'z') {
                leftIndex++;
                continue;
            }
            if (rightChar < 'a' || rightChar > 'z') {
                rightIndex--;
                continue;
            }
            if (leftChar != rightChar) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    public static void main(String[] args) {
        valid_palindrome solution = new valid_palindrome();
        System.out.println("true = " + solution.isPalindrome(" !$%^&|&&ADA      "));
        System.out.println("true = " + solution.isPalindrome("AAAAAA"));
        System.out.println("true = " + solution.isPalindrome("racecar"));
        System.out.println("true = " + solution.isPalindrome(""));
        System.out.println("true = " + solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("false = " + solution.isPalindrome("race a car"));
    }
}
