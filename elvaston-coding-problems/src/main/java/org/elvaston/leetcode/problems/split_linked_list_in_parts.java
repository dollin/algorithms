package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.ListNode;
import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.linked_list;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/split-linked-list-in-parts/
 *
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
 *
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.
 *
 * The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
 *
 * Return a List of ListNode's representing the linked list parts that are formed.
 *
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 * Example 1:
 * Input:
 * root = [1, 2, 3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The input and each element of the output are ListNodes, not arrays.
 * For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but it's string representation as a ListNode is [].
 * Example 2:
 * Input:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 * Note:
 *
 * The length of root will be in the range [0, 1000].
 * Each value of a node in the input will be an integer in the range [0, 999].
 * k will be an integer in the range [1, 50].
 */
@medium
@linked_list
public class split_linked_list_in_parts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] parts = new ListNode[k];
        int length = len(root);

        int[] sizes = new int[k];
        int remaining = length;

        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = remaining / (k - i);
            if (remaining % (k - i) != 0) {
                sizes[i]++;
            }
            remaining -= sizes[i];
        }

        ListNode tempPointer = root;
        for (int i = 0; i < parts.length; i++) {
            ListNode dummyPointer = tempPointer;
            ListNode jumpAhead = dummyPointer;

            for (int j = 0; j < sizes[i] - 1; j++) {
                jumpAhead = jumpAhead.next;
            }

            if (jumpAhead != null) {
                tempPointer = jumpAhead.next;
                jumpAhead.next = null;
            } else {
                tempPointer = null;
            }

            parts[i] = dummyPointer;
        }
        return parts;
    }

    private int len(ListNode n) {
        int count = 0;
        while (n != null) {
            n = n.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        split_linked_list_in_parts solution = new split_linked_list_in_parts();
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        Arrays.stream(solution.splitListToParts(n, 5)).forEach((node -> System.out.println(node != null ? node.val : "nul"));
    }
}
