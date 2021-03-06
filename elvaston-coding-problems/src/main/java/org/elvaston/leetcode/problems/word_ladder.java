package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.tags.breadth_first_search;
import org.elvaston.leetcode.difficulty.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder/
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
@medium
@breadth_first_search
public class word_ladder {

    public static void main(String... args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        ladderLength(beginWord, endWord, wordList);
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 0;
        }
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }

        // check endWord should be in wordList
        Set<String> words = new HashSet<String>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }

        // enqueue only when it can be closer to optimal solution
        Map<String, Integer> visited = new HashMap<String, Integer>();

        // bfs
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        visited.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String head = queue.poll();
            int step = visited.get(head);
            char[] cs = head.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                for (int j = 0; j < 26; j++) {
                    char c = (char) ('a' + j);
                    if (c != head.charAt(i)) {
                        cs[i] = c;
                        String next = new String(cs);
                        if (next.equals(endWord)) {
                            return step + 1;
                        }

                        if (words.contains(next) && (!visited.containsKey(next) || visited.get(next) > step + 1)) {
                            visited.put(next, step + 1);
                            queue.offer(next);
                        }
                        cs[i] = head.charAt(i);
                    }
                }
            }
        }
        return 0;
    }
}
