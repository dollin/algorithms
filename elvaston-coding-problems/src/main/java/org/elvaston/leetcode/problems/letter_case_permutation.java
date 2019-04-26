package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.tags.backtracking;
import org.elvaston.leetcode.tags.bit_manipulation;
import org.elvaston.leetcode.difficulty.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * https://leetcode.com/problems/letter-case-permutation/
 *
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 * Note:
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */
@easy
@backtracking
@bit_manipulation
public class letter_case_permutation {
    public List<String> letterCasePermutation(String s) {
        List<String> permutations = new ArrayList<>();
        permutations.add(s);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            add(permutations, i, chars[i], 'a', 'z', toUpper);
            add(permutations, i, chars[i], 'A', 'Z', toLower);
        }
        return permutations;
    }

    private Function<Character, Character> toUpper = c -> (char) (c & 95);
    private Function<Character, Character> toLower = c -> (char) (c ^ 32);

    private void add(List<String> p, int i, char c, char from, char to, Function<Character, Character> f) {
        if (c >= from && c <= to) {
            List<String> permutations = new ArrayList<>();
            for (String word : p) {
                char[] newchars = word.toCharArray();
                newchars[i] = f.apply(newchars[i]);
                permutations.add(new String(newchars));
            }
            p.addAll(permutations);
        }
    }

    public static void main(String[] args) {
        letter_case_permutation solution = new letter_case_permutation();
        System.out.println(solution.letterCasePermutation("a1b2"));
    }
}
