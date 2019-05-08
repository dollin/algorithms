package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.backtracking;
import org.elvaston.leetcode.tags.trie;

/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 *
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
@medium
@backtracking
@trie
public class add_and_search_word_data_structure_design {

    static class WordDictionary {

        private class Node {
            char c;
            Node[] next = new Node[26];
            boolean isEnd;

            Node(char c) {
                this.c = c;
            }
            Node() {
            }

        }

        private Node root = new Node();
        /** Initialize your data structure here. */
        public WordDictionary() {
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            addWord(root, word, 0);
        }

        private void addWord(Node node, String word, int i) {
            if (word.length() > i) {
                if (node.next[word.charAt(i) - 'a'] == null) {
                    node.next[word.charAt(i) - 'a'] = new Node(word.charAt(i));
                }
                addWord(node.next[word.charAt(i) - 'a'], word, i + 1);
            } else {
                node.isEnd = true;
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return search(root, word, 0);
        }

        private boolean search(Node node, String word, int i) {
            if (word.length() > i && word.charAt(i) == '.') {
                boolean hasMatch = false;
                for (Node n : node.next) {
                    if (n != null) {
                        hasMatch |= search(n, word, i + 1);
                    }
                }
                return hasMatch;
            } else if (word.length() > i && node != null && node.next[word.charAt(i) - 'a'] != null) {
                return search(node.next[word.charAt(i) - 'a'], word, i + 1);
            } else {
                return i == word.length() && node.isEnd;
            }
        }
    }

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("a");
        dict.addWord("a");
        dict.addWord("mad");
        System.out.println(dict.search("pad")); //-> false
        System.out.println(dict.search("bad")); //-> true
        System.out.println(dict.search(".ad")); //-> true
        System.out.println(dict.search("aa")); //-> false
        System.out.println(dict.search("a.")); //-> false
        System.out.println(dict.search(".a")); //-> true
        System.out.println(dict.search(".")); //-> true
        System.out.println(dict.search("a")); //-> true
    }
}
