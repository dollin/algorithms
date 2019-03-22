package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.hash_table;
import org.elvaston.leetcode.tags.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
@medium
@hash_table
@string
public class group_anagrams {

    public List<List<String>> group(String[] anagrams) {
        List<List<String>> groups = new ArrayList<>();
        Map<String, List<String>> groupBySorted = new HashMap<>();
        for (String word: anagrams) {
            String s = sort(word);
            groupBySorted.putIfAbsent(s, new ArrayList<>());
            groupBySorted.get(s).add(word);
        }
        groups.addAll(groupBySorted.values());
        return groups;
    }

    private String sort(String word) {
        char[] c = word.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    public static void main(String[] args) {
        group_anagrams solution = new group_anagrams();
        System.out.println(solution.group(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
