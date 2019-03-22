package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.TreeNode;
import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.breadth_first_search;
import org.elvaston.leetcode.tags.depth_first_search;
import org.elvaston.leetcode.tags.tree;

/**
 * https://leetcode.com/problems/symmetric-tree/
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
@easy
@breadth_first_search
@depth_first_search
@tree
public class symmetric_tree {

    public boolean isSymmetric(TreeNode node) {
        if (node == null) {
            return true;
        }
        return isSym(node.left, node.right);
    }

    private boolean isSym(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSym(left.left, right.right) && isSym(left.right, right.left);
    }
}
