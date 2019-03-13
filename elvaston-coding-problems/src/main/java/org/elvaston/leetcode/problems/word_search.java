package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.array;
import org.elvaston.leetcode.tags.backtracking;

/**
 * https://leetcode.com/problems/word-search/
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
@medium
@array
@backtracking
public class word_search {
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (hasWord(board, i, j, word, 0, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
            System.out.println();
        }
        return false;
    }

    private boolean hasWord(char[][] board, int i, int j, String word, int wordIndex, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return false;
        }
        if (board[i][j] == word.charAt(wordIndex)) {
            if (wordIndex == word.length() - 1) {
                return true;
            }
            visited[i][j] = true;
            if (hasWord(board, i + 1, j, word, wordIndex + 1, visited)
                    || hasWord(board, i, j + 1, word, wordIndex + 1, visited)
                    || hasWord(board, i, j - 1, word, wordIndex + 1, visited)
                    || hasWord(board, i - 1, j, word, wordIndex + 1, visited)) {

                return true;
            } else {
                visited[i][j] = false;
            }
        }
        return false;
    }
}
