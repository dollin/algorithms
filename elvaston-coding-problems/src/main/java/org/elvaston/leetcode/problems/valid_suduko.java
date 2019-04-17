package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.hash_table;

/**
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */

@medium
@hash_table
public class valid_suduko {

    public boolean isValidSudoku(char[][] board) {
        return checkRow(board) && checkColumn(board) && checkSquare(board);
    }

    private boolean checkRow(char[][] board) {
        return check(board, true);
    }

    private boolean checkColumn(char[][] board) {
        return check(board, false);
    }

    private boolean check(char[][] board, boolean rows) {
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[10];
            for (int j = 0; j < 9; j++) {
                char c = (rows ? board[i][j] : board[j][i]);
                if (c != '.') {
                    if (seen[c - '0']) {
                        return false;
                    }
                    seen[c - '0'] = true;
                }
            }
        }
        return true;
    }

    private boolean checkSquare(char[][] board) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] seen = new boolean[10];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (board[k][l] != '.') {
                            if (seen[board[k][l] - '0']) {
                                return false;
                            }
                            seen[board[k][l] - '0'] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
