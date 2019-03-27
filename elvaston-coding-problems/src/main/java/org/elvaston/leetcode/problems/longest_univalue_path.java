package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.TreeNode;
import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.recursion;
import org.elvaston.leetcode.tags.tree;

/**
 * https://leetcode.com/problems/longest-univalue-path/
 *
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * Input:
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * Output: 2
 *
 * Input:
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * Output: 2
 *
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
@easy
@recursion
@tree
public class longest_univalue_path {

    private int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        univalue(root);
        return ans;
    }

    private int univalue(TreeNode n) {
        if (n == null) {
            return 0;
        }
        int left = univalue(n.left);
        int right = univalue(n.right);
        int lPath = 0;
        if (n.left != null && n.left.val == n.val) {
            lPath = left + 1;
        }
        int rPath = 0;
        if (n.right != null && n.right.val == n.val) {
            rPath = right + 1;
        }
        ans = Math.max(ans, rPath + lPath);
        return Math.max(rPath, lPath);
    }
}
