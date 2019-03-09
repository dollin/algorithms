package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.ListNode;
import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.linked_list;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
@medium
@linked_list
public class add_two_numbers_ii {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first_with_buffer = new ListNode(0);
        ListNode second_with_buffer = new ListNode(0);
        ListNode return_node_with_buffer = new ListNode(0);

        first_with_buffer.next = l1;
        second_with_buffer.next = l2;

        int carry = 0;
        while (first_with_buffer.next != null || second_with_buffer.next != null || carry > 0) {
            carry += removeLast(first_with_buffer) + removeLast(second_with_buffer);
            ListNode n = new ListNode(carry % 10);
            carry /= 10;
            n.next = return_node_with_buffer.next;
            return_node_with_buffer.next  = n;
        }
        return return_node_with_buffer.next;
    }

    private int removeLast(ListNode n) {
        ListNode prev = null;
        while (n != null && n.next != null) {
            prev = n;
            n = n.next;
        }
        int val = n.val;
        if (prev != null) {
            prev.next = null;
        }
        return val;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        n1.next = new ListNode(2);
        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(2);
        n2.next.next = new ListNode(3);
        n2.next.next.next = new ListNode(4);
        System.out.println(new add_two_numbers_ii().addTwoNumbers(n1, n2));
    }
}
