package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.breadth_first_search;

/**
 * https://leetcode.com/problems/rotting-oranges/
 *
 * In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 *
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 *
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 *
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 * Note:
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 */
@easy
@breadth_first_search
class rotting_oranges {

    public static int orangesRotting(int[][] grid) {
        boolean[][] rotting = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rotting[i][j] = true;
                }
            }
        }

        int minutes = 0;
        for (int k = 0; k < grid.length * grid[0].length; k++) {

            boolean updated = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    updated |= update(i, j, grid, rotting);
                }
            }
            if (updated) {
                minutes++;
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (rotting[i][j]) {
                        grid[i][j] = 2;
                    }
                }
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    System.out.print(grid[i][j] + ", ");
                }
                System.out.println();
            }
            System.out.println();
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minutes;
    }

    private static boolean update(int i, int j, int[][] grid, boolean[][] rotting) {
        if (grid[i][j] == 1) {
            if (i >= 1 && grid[i - 1][j] == 2) {
                rotting[i][j] = true;
            } else if (j >= 1 && grid[i][j - 1] == 2) {
                rotting[i][j] = true;
            } else if (i < grid.length -1 && grid[i + 1][j] == 2) {
                rotting[i][j] = true;
            } else if (j < grid[0].length -1 && grid[i][j + 1] == 2) {
                rotting[i][j] = true;
            }
        } else {
            return false;
        }
        return rotting[i][j];
    }

    public static void main(String[] args) {
//        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
//        System.out.println(orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
//        System.out.println(orangesRotting(new int[][]{{0,2}}));
//        System.out.println(orangesRotting(new int[][]{{1}, {2}}));
        System.out.println(orangesRotting(new int[][]{{2,1,1,1,1,1,1,1,1,1},{0,0,0,0,0,0,0,0,0,1},{1,1,1,1,1,1,1,1,0,1},{1,0,0,0,0,0,0,1,0,1},{1,0,1,1,1,1,0,1,0,1},{1,0,1,0,0,1,0,1,0,1},{1,0,1,0,0,0,0,1,0,1},{1,0,1,1,1,1,1,1,0,1},{1,0,0,0,0,0,0,0,0,1},{1,1,1,1,1,1,1,1,1,1}}));
    }
}