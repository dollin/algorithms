package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.depth_first_search;

/**
 * https://leetcode.com/problems/surrounded-regions/
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
@depth_first_search
@medium
public class surrounded_regions {

    public void solve(char[][] board) {
        if (board.length <= 1 || board[0].length <= 1) {
            return;
        }

        update(board, 'O', '-');
        board[0][0] = board[0][0] == '-' ? 'O' : 'X';
        board[0][board[0].length - 1] = board[0][board[0].length - 1] == '-' ? 'O' : 'X';
        board[board.length - 1][0] = board[board.length - 1][0] == '-' ? 'O' : 'X';
        board[board.length - 1][board[0].length - 1] = board[board.length - 1][board[0].length - 1] == '-' ? 'O' : 'X';
        print(board);
        System.out.println();
        infill(board);
        print(board);
        System.out.println();
        update(board, '-', 'X');
        print(board);
    }

    private void infill(char[][] board) {
        for (int i = 1; i < board.length - 1; i++) {
            infill(board, i, 0);
            infill(board, i, board[0].length - 1);
        }
        for (int i = 1; i < board[0].length - 1; i++) {
            infill(board, 0, i);
            infill(board, board.length - 1, i);
        }
    }

    private void infill(char[][] board, int row, int col) {
        if (0 <= row
                && row <= board.length - 1
                && 0 <= col
                && col <= board[0].length - 1) {
            if (board[row][col] == '-') {
                board[row][col] = 'O';
                infill(board, row - 1, col);
                infill(board, row + 1, col);
                infill(board, row, col - 1);
                infill(board, row, col + 1);
            }
        }
    }

    private void update(char[][] board, char from, char to) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == from) {
                    board[i][j] = to;
                }
            }
        }
    }

    public static void main(String[] args) {

        surrounded_regions solution = new surrounded_regions();
        solution.solve(new char[][]{
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}
        });
    }

    private static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }
    }
}
