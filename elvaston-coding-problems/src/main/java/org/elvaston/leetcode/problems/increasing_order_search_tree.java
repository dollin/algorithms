package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.TreeNode;
import org.elvaston.leetcode.tags.depth_first_search;
import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 *
 * Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
 *
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 */
@easy
@depth_first_search
@tree
public class increasing_order_search_tree {
    public TreeNode increasingBST(TreeNode root) {
        Queue<Integer> q = new ArrayDeque<>();
        dfs(root, q);
        TreeNode ordered = new TreeNode(q.remove());
        TreeNode t = ordered;
        while (!q.isEmpty()) {
            t.right = new TreeNode(q.remove());
            t = t.right;
        }
        return ordered;
    }

    private void dfs(TreeNode node, Queue<Integer> q) {
        if(node == null) {
            return;
        }
        dfs(node.left, q);
        q.add(node.val);
        dfs(node.right, q);
    }

    public static void main(String[] args) {
        increasing_order_search_tree sol = new increasing_order_search_tree();
        TreeNode t = new TreeNode(2, 3, 4);
        System.out.println(t + "=" + sol.increasingBST(t));
    }
}
