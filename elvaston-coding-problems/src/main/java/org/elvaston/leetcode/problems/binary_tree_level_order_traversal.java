package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.TreeNode;
import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.breadth_first_search;
import org.elvaston.leetcode.tags.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
@medium
@breadth_first_search
@tree
public class binary_tree_level_order_traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> levels = new HashMap<>();
        addLevel(root, levels, 0);

        List<List<Integer>> returnLevels = new ArrayList<>();
        for (int level = 0; level < levels.size(); level++) {
            returnLevels.add(new ArrayList<>(levels.get(level)));
        }
        return returnLevels;
    }

    private void addLevel(TreeNode node, Map<Integer, List<Integer>> levels, int key) {
        if (node == null) {
            return;
        }
        List<Integer> level = levels.getOrDefault(key, new ArrayList<>());
        level.add(node.val);
        levels.put(key, level);
        addLevel(node.left, levels, key + 1);
        addLevel(node.right, levels, key + 1);
    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        t.right.right.right = new TreeNode(17);

        System.out.println(new binary_tree_level_order_traversal().levelOrder(t));
    }
}
