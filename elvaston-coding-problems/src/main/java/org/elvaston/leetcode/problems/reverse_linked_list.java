package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.ListNode;
import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.linked_list;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Reverse a singly linked list.
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
@easy
@linked_list
public class reverse_linked_list {

    public ListNode reverseList(ListNode head) {
        return recursiveReverse(head);
    }

    private ListNode recursiveReverse(ListNode node) {
        if (node.next == null) {
            return node;
        }

        ListNode reversed = recursiveReverse(node.next);
        node.next.next = node;
        node.next = null;
        return reversed;
    }

    public ListNode iterativeReverse(ListNode head) {
        ListNode node = head;
        ListNode reversed = null;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = reversed;
            reversed = node;
            node = tmp;
        }
        return reversed;
    }
}
