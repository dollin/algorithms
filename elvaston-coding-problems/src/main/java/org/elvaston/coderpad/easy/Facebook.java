package org.elvaston.coderpad.easy;

import org.elvaston.leetcode.datastructures.TreeNode;
import org.elvaston.leetcode.tags.array;
import org.elvaston.leetcode.tags.binary_search;
import org.elvaston.leetcode.tags.depth_first_search;
import org.elvaston.leetcode.tags.tree;

import java.util.ArrayList;
import java.util.List;

@array
@binary_search
@depth_first_search
@tree
public class Facebook {

    private List<Integer> interSection(int[] a, int[] b) {
        List<Integer> inter = new ArrayList<>();
        int indexA = 0;
        int indexB = 0;
        for (; indexA < a.length && indexB < b.length;) {
            if (a[indexA] == b[indexB]) {
                //if (!inter.contains(a[indexA])) {
                if (indexA == 0 || a[indexA - 1] != a[indexA] || indexB == 0 || b[indexB - 1] != b[indexB]) {
                    inter.add(a[indexA]);
                }
                indexA++;
                indexB++;
            } else if (a[indexA] < b[indexB]) {
                indexA++;
            } else {
                indexB++;
            }
        }
        return inter;
    }


    private List<Integer> interSectionWithBS(int[] a, int[] b) {
        List<Integer> inter = new ArrayList<>();
        int[] key = a.length < b.length ? a : b;

        int prev_key = 0;
        for (int i : key) {
            if (find(i, a.length < b.length ? b : a) && (inter.size() == 0 || prev_key != i)) {
                inter.add(i);
                prev_key = i;
            }
        }
        return inter;
    }

    private boolean find(int i, int[] ints) {
        for (int ele: ints) {
            if (ele == i) {
                return true;
            }
        }
        return false;
    }

    public int length(TreeNode node) {
        return lengthWithCurrMax(node, 0);
    }

    private int lengthWithCurrMax(TreeNode node, int currMax) {
        if (node == null) {
            return 0;
        }
        int left = lengthWithCurrMax(node.left, currMax);
        int right = lengthWithCurrMax(node.right, currMax);

        return Math.max(left + right, Math.max(currMax + left, currMax + right) + 1);
    }

    public static void main(String[] args) {
        Facebook fb = new Facebook();
        System.out.println("for = " + fb.interSection(new int[]{2,2,2,2,3}, new int[]{1,2,2,2,3,4}));
        System.out.println("BS  = " + fb.interSectionWithBS(new int[]{2,2,2,2,3}, new int[]{1,2,2,2,3,4}));
        {
            TreeNode t = new TreeNode(1);
            t.left = new TreeNode(2);
            t.right = new TreeNode(3);
            t.right.right = new TreeNode(4);
            System.out.println("3 = " + fb.length(t));
        }
        {
            TreeNode t = new TreeNode(1);
            t.left = new TreeNode(2);
            t.right = new TreeNode(2);
            t.right.right = new TreeNode(2);
            t.right.right.right = new TreeNode(2);
            t.right.right.right.right = new TreeNode(2);
            t.left.left = new TreeNode(3);
            t.left.left.left = new TreeNode(4);
            t.left.right = new TreeNode(5);
            t.left.right.right = new TreeNode(6);
            t.left.right.right.right = new TreeNode(7);
            t.left.right.right.right.right = new TreeNode(8);
            System.out.println("10 = " + fb.length(t));
        }
        {
            TreeNode t = new TreeNode(1);
            t.left = new TreeNode(2);
            t.left.left = new TreeNode(3);
            t.left.left.left = new TreeNode(4);
            t.left.right = new TreeNode(5);
            t.left.right.right = new TreeNode(6);
            t.left.right.right.right = new TreeNode(7);
            t.left.right.right.right.right = new TreeNode(8);
            System.out.println("7 = " + fb.length(t));
        }
    }
}
