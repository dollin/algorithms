package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.array;
import org.elvaston.leetcode.tags.hash_table;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-common-characters/
 *
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
 *
 * You may return the answer in any order.
 *
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 *
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 */
@easy
@array
@hash_table
public class find_common_characters {
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";

    private List<String> commonChars(String[] words) {
        List<String> commonChars = new ArrayList<>();
        int[][] counts = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                counts[i][words[i].charAt(j) - 'a']++;
            }
        }
        print(counts);

        for (int i = 0; i < counts[0].length; i++) {
            int counter = Integer.MAX_VALUE;
            for (int j = 0; j < counts.length; j++) {
                counter = Math.min(counter, counts[j][i]);
                if (counter == 0) {
                    break;
                }
            }
            while (counter > 0) {
                commonChars.add("" + alphabet.charAt(i));
                counter--;
            }
        }
        return commonChars;
    }

    private void print(int[][] counts) {
        for (int i = 0; i < alphabet.length(); i++) {
            System.out.print(alphabet.charAt(i) + ", ");
        }
        System.out.println();
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i].length; j++) {
                System.out.print(counts[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        find_common_characters solution = new find_common_characters();
        System.out.println(solution.commonChars(new String[]{"bellaaa", "celloaa", "ella"}));
    }
}
