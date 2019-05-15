package org.elvaston.daily_coding_problem;

import org.elvaston.leetcode.datastructures.TreeNode;

/**
 * Problem #3
 * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string,
 * and deserialize(s), which deserializes the string back into the tree.
 */
public class serialize_deserialize_nodetree {

    public String serialize(TreeNode n) {
        return serializeNode(n);
    }

    private String serializeNode(TreeNode n) {
        String s = (n == null ? "n," : n.val + ",");
        if (n != null) {
            s += serializeNode(n.left);
            s += serializeNode(n.right);
        }
        return s;
    }

    public TreeNode deserialize(String s) {
        TreeNode n = de(s.split(","));
        return n;
    }

    int index = 0;
    private TreeNode de(String[] vals) {
        TreeNode node;
        if ("n".equals(vals[index])) {
            node = null;
        } else {
            node = new TreeNode(Integer.valueOf(vals[index]));
            index++;
            node.left = de(vals);
            index++;
            node.right = de(vals);
        }
        return node;
    }

    public static void main(String[] args) {
        serialize_deserialize_nodetree solution = new serialize_deserialize_nodetree();
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(4);
        System.out.println(solution.serialize(n));
        System.out.println(solution.serialize(solution.deserialize("1,2,n,n,4,n,n,")));
    }
}
