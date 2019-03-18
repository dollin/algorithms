package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.TreeNode;
import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.depth_first_search;
import org.elvaston.leetcode.tags.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
@medium
@tree
@depth_first_search
public class binary_tree_zigzag_level_order_traversal {

    public List<List<Integer>> zigzag(TreeNode t) {
        List<List<Integer>> zigzag = new ArrayList<>();
        int depth = depth(t);
        for (int i = 0; i < depth; i++) {
            List<Integer> zz = new ArrayList<>();
            zigzag(t, i, 0, zz);
            zigzag.add(zz);
        }
        return zigzag;
    }

    private int depth(TreeNode t) {
        if (t == null) {
            return 0;
        }
        return Math.max(depth(t.left), depth(t.right)) + 1;
    }

    private void zigzag(TreeNode t, int i, int depth, List<Integer> zz) {
        if (t == null) {
            return;
        }
        if (i == depth) {
            zz.add(t.val);
        } else {
            zigzag(i % 2 == 0 ? t.left : t.right, i, depth + 1, zz);
            zigzag(i % 2 == 0 ? t.right : t.left, i, depth + 1, zz);
        }
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(2);
        t.left.left = new TreeNode(1);
        t.left.left.left = new TreeNode(1001);
        t.left.right = new TreeNode(5);
        t.right = new TreeNode(4);
        t.right.left = new TreeNode(10);
        t.right.right = new TreeNode(100);
        t.right.right.left = new TreeNode(101);
        t.right.right.right = new TreeNode(102);

        System.out.println(new binary_tree_zigzag_level_order_traversal().zigzag(t));
    }
}
