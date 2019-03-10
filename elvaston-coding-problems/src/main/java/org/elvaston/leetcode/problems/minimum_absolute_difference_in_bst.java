package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.TreeNode;
import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.binary_search_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 *
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * Output:
 * 1
 *
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 *
 *
 * Note: There are at least two nodes in this BST.
 */
@easy
@binary_search_tree
public class minimum_absolute_difference_in_bst {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> sortedNums = new ArrayList<>();

        sort(root, sortedNums);

        return getMin(sortedNums);
    }

    private int getMin(List<Integer> sortedNums) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < sortedNums.size(); i++) {
            int diff = sortedNums.get(i) - sortedNums.get(i - 1);
            if (diff  < min) {
                min = diff;
            }
        }
        return min;
    }

    private void sort(TreeNode t, List<Integer> sortedNums) {
        if (t != null) {
            sort(t.left, sortedNums);
            sortedNums.add(t.val);
            sort(t.right, sortedNums);
        }
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(236);
        t.left = new TreeNode(104);
        t.left.right = new TreeNode(227);
        t.right = new TreeNode(701);
        t.right.right = new TreeNode(901);
        System.out.println(new minimum_absolute_difference_in_bst().getMinimumDifference(t));
    }
}
