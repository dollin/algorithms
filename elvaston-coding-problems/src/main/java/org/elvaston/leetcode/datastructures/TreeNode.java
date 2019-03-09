package org.elvaston.leetcode.datastructures;

public class TreeNode {
    public TreeNode right;
    public int val;
    public TreeNode left;
    public TreeNode(int x) { val = x; }

    public TreeNode(int left, int x, int right) {
        this.val = x;
        this.left = new TreeNode(left);
        this.right = new TreeNode(right);
    }

    @Override
    public String toString() {
        return "[" + (left == null ? "" : left + "<-") + val + (right == null ? "" : "->" + right) + "]";
    }
}
