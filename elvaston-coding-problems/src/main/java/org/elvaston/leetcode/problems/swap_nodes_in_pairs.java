package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.ListNode;
import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.linked_list;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
@medium
@linked_list
public class swap_nodes_in_pairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode n = dummy;
        while (n.next != null && n.next.next != null) {
            ListNode tmp = n.next;
            n.next = n.next.next;
            tmp.next = n.next.next;
            n.next.next = tmp;
            n = n.next.next;
        }
        return dummy.next;
    }

}
