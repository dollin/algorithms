package org.elvaston.daily_coding_problem;

import org.elvaston.leetcode.datastructures.TreeNode;

/**
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 *
 * Given the root to a binary tree, count the number of unival subtrees.
 *
 * For example, the following tree has 5 unival subtrees:
 *
 *    0
 *   / \
 *  1   0
 *     / \
 *    1   0
 *   / \
 *  1   1
 */
public class universal_tree {
    public int countUniversals(TreeNode root) {

        return countUni(root, root.val);
    }

    private int countUni(TreeNode n, int val) {
        if (n == null) {
            return 0;
        }
        if (n.left == null && n.right != null) {
            return countUni(n.right, n.right.val);
        } else if (n.left != null && n.right == null) {
            return countUni(n.left, n.left.val);
        } else if (n.left == null && n.right == null) {
            return 1;
        }
        return countUni(n.left, n.left.val) + countUni(n.right, n.right.val) + (n.val == n.left.val && n.val == n.right.val ? 1 : 0);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(0);
        t.left = new TreeNode(1);
        t.right = new TreeNode(0);
        t.right.left = new TreeNode(1);
        t.right.left.left = new TreeNode(1);
        t.right.left.right = new TreeNode(1);
        t.right.right = new TreeNode(0);

        System.out.println(new universal_tree().countUniversals(t));
        System.out.println(new universal_tree().countUniversals(new TreeNode(1)));
    }
}
