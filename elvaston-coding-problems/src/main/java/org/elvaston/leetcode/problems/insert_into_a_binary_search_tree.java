package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.TreeNode;
import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.tree;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 *
 * Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 *
 * For example,
 *
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * And the value to insert: 5
 * You can return this binary search tree:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * This tree is also valid:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 */
@medium
@tree
public class insert_into_a_binary_search_tree {

    public TreeNode insertIntoBST(TreeNode node, int val) {
        findPosition(node, val);
        return node;
    }

    public static void findPosition(TreeNode node, int val) {
        if (node != null && node.val < val) {
            if (node.right != null) {
                findPosition(node.right, val);
            } else {
                node.right = new TreeNode(val);
            }
        } else if (node != null && node.val > val) {
            if (node.left != null) {
                findPosition(node.left, val);
            } else {
                node.left = new TreeNode(val);
            }
        }
    }
}
