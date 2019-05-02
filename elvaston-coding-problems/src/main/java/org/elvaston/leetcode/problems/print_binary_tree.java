package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.TreeNode;
import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/print-binary-tree/
 *
 * Print a binary tree in an m*n 2D string array following these rules:
 * The row number m should be equal to the height of the given binary tree.
 * The column number n should always be an odd number.
 * The root node's value (in string format) should be put in the exactly middle of the first row it can be put.
 * The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part).
 * You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part.
 * The left-bottom part and the right-bottom part should have the same size.
 * Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the
 * space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
 * Each unused space should contain an empty string "".
 * Print the subtrees following the same rules.
 * Example 1:
 * Input:
 *      1
 *     /
 *    2
 * Output:
 * [["", "1", ""],
 *  ["2", "", ""]]
 *
 * Example 2:
 * Input:
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 * Output:
 * [["", "", "", "1", "", "", ""],
 *  ["", "2", "", "", "", "3", ""],
 *  ["", "", "4", "", "", "", ""]]
 *
 * Example 3:
 * Input:
 *       1
 *      / \
 *     2   5
 *    /
 *   3
 *  /
 * 4
 * Output:
 *
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 *
 * Note: The height of binary tree is in the range of [1, 10].
 */
@medium
@tree
public class print_binary_tree {

    public List<List<String>> printTree(TreeNode root) {

        int height = height(root);
        int width = ((int) Math.pow(2, height)) - 1;

        String[][] grid = new String[height][width];

        populate(grid);

        fill(grid, root, 0, width / 2);

        //print(grid);

        return asList(grid);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private List<List<String>> asList(String[][] grid) {
        List<List<String>> solution = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                row.add(grid[i][j]);
            }
            solution.add(row);
        }
        return solution;
    }

    private void fill(String[][] grid, TreeNode node, int row, int column) {
        if (node == null) {
            return;
        }
        grid[row][column] = String.valueOf(node.val);

        fill(grid, node.left, row + 1, column - (int) Math.pow(2, grid.length - row - 2));
        fill(grid, node.right, row + 1, column + (int) Math.pow(2, grid.length - row - 2));
    }

    private void populate(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = "";
            }
        }
    }

    private void print(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print("[" + i + "," + j + "]=" + grid[i][j]);
            }
            System.out.println();
        }
    }
}

