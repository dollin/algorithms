package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.TreeNode;
import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.tree;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Invert a binary tree.
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
@easy
@tree
public class invert_binary_tree {

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invert(root.left);
        invert(root.right);
    }
}
