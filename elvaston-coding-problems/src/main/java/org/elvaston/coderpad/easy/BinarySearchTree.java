package org.elvaston.coderpad.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of BinarySearchTree.
 */
public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        this.root = new Node();
    }

    public void put(int value) {
        add(root, value);
    }

    private void add(Node node, int value) {
        if (node.val == null) {
            node.val = value;
            node.left = new Node();
            node.right = new Node();
        } else {
            if (value > node.val) {
                add(node.right, value);
            } else if (value < node.val) {
                add(node.left, value);
            }
        }
    }

    public boolean contains(int value) {
        return inTree(root, value);
    }

    private boolean inTree(Node node, int value) {
        if (node.val != null && node.val == value) {
            return true;
        } else {
            if (node.val == null) {
                return false;
            } else {
                if (value > node.val) {
                    return inTree(node.right, value);
                } else {
                    return inTree(node.left, value);
                }
            }
        }
    }

    /**
     * Get the items in order.
     * @return List
     */
    public List<Integer> inOrderTraversal() {
        final ArrayList<Integer> acc = new ArrayList<>();
        inOrderTraversal(root, acc);
        return acc;
    }

    private void inOrderTraversal(Node node, List<Integer> acc) {
        if (node.val == null) {
            return;
        }
        inOrderTraversal(node.left, acc);
        acc.add(node.val);
        inOrderTraversal(node.right, acc);
    }

    private static class Node {
        Integer val;
        Node left;
        Node right;

        @Override
        public String toString() {
            return val == null ? "null" : val.toString();
        }
    }
}
