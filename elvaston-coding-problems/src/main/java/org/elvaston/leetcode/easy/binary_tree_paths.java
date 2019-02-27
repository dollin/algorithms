package org.elvaston.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 * Given a binary tree, return all root-to-leaf paths.
 * Note: A leaf is a node with no children.
 * Example:
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class binary_tree_paths {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        addPath(root, "", paths);
        return paths;
    }

    private void addPath(TreeNode node, String path, List<String> paths) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (!paths.contains(path)) {
                paths.add(val(path, node.val));
            }
            return;
        }
        if (node.left != null) {
            addPath(node.left, val(path, node.val), paths);
        }
        if (node.right != null) {
            addPath(node.right, val(path, node.val), paths);
        }

    }

    private String val(String path, int val) {
        return "".equals(path) ? "" + val : path + "->" + val;
    }
}
