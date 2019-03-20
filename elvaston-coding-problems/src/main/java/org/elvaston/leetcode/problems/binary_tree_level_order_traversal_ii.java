package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.TreeNode;
import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.breadth_first_search;
import org.elvaston.leetcode.tags.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
@easy
@breadth_first_search
@tree
public class binary_tree_level_order_traversal_ii {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> returnLevels = new ArrayList<>();
        Map<Integer, List<Integer>> levels = new HashMap<>();
        int maxKey = calcLevelAndReturnDepth(root, levels, 0);

        for (int i = maxKey - 1; i >= 0; i--) {
            returnLevels.add(levels.get(i));
        }
        return returnLevels;
    }

    private int calcLevelAndReturnDepth(TreeNode node, Map<Integer, List<Integer>> allLevels, int i) {
        if (node == null) {
            return 0;
        }
        List<Integer> level = allLevels.getOrDefault(i, new ArrayList<>());
        level.add(node.val);
        allLevels.put(i, level);
        return Math.max(calcLevelAndReturnDepth(node.left, allLevels, i + 1), calcLevelAndReturnDepth(node.right, allLevels, i + 1)) + 1;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        t.right.right.right = new TreeNode(17);

        System.out.println(new binary_tree_level_order_traversal_ii().levelOrderBottom(t));
    }
}
