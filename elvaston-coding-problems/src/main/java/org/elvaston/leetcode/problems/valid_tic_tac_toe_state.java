package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.math;

/**
 * https://leetcode.com/problems/valid-tic-tac-toe-state/
 *
 * A Tic-Tac-Toe board is given as a string array board. Return True if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.
 *
 * The board is a 3 x 3 array, and consists of characters " ", "X", and "O".  The " " character represents an empty square.
 *
 * Here are the rules of Tic-Tac-Toe:
 *
 * Players take turns placing characters into empty squares (" ").
 * The first player always places "X" characters, while the second player always places "O" characters.
 * "X" and "O" characters are always placed into empty squares, never filled ones.
 * The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 *
 * Input: board = ["O  ", "   ", "   "]
 * Output: false
 * Explanation: The first player always plays "X".
 *
 * Input: board = ["XOX", " X ", "   "]
 * Output: false
 * Explanation: Players take turns making moves.
 *
 * Input: board = ["XXX", "   ", "OOO"]
 * Output: false
 *
 * Input: board = ["XOX", "O O", "XOX"]
 * Output: true
 * Note:
 *
 * board is a length-3 array of strings, where each string board[i] has length 3.
 * Each board[i][j] is a character in the set {" ", "X", "O"}.
 */
@medium
@math
public class valid_tic_tac_toe_state {
    public boolean validTicTacToe(String[] board) {
        if (board[0].equals("   ") && board[1].equals("   ") && board[2].equals("   ")) {
            return true;
        }
        int O = 0;
        int X = 0;

        for (int i = 0; i < board.length; i++) {
            for (char c : board[i].toCharArray()) {
                if (c == 'X') {
                    X++;
                } else if (c == 'O') {
                    O++;
                }
            }
        }
        if (X < O || X - O >= 2) {
            return false;
        }

        if (hasWon(board, 'X') && X == O) {
            return false;
        }

        if (hasWon(board, 'O') && X != O) {
            return false;
        }

        if (hasWon(board, 'X') && hasWon(board, 'O')) {
            return false;
        }
        return true;
    }

    private static boolean hasWon(String[] board, char x) {
        String val = "" + x + "" + x + "" + x;

        for (int i = 0; i < 3; i++) {
            if (val.equals(board[i])) {
                return true;
            }
            if (x == board[0].charAt(i)
                    && x == board[1].charAt(i) && x == board[2].charAt(i)) {
                return true;
            }
            if (x == board[0].charAt(0)
                    && x == board[1].charAt(1) && x == board[2].charAt(2)) {
                return true;
            }
            if (x == board[0].charAt(2)
                    && x == board[1].charAt(1) && x == board[2].charAt(0)) {
                return true;
            }
        }
        return false;
    }
}
