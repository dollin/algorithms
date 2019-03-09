package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.ListNode;
import org.elvaston.leetcode.tags.linked_list;
import org.elvaston.leetcode.tags.math;
import org.elvaston.leetcode.difficulty.medium;

/**
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
@medium
@linked_list
@math
public class add_two_numbers {
    public static ListNode addTwoNumbers(ListNode list_a, ListNode list_b) {
        int sum = 0;
        ListNode list_i = list_a;
        while (list_i != null && list_b != null) {
            sum += list_i.val + list_b.val;
            list_i.val = sum % 10;
            sum /= 10;

            if (list_i.next == null && list_b.next != null) {
                list_i.next = new ListNode(0);
            }
            list_i = list_i.next;

            if (list_b.next != null) {
                list_b = list_b.next;
            } else {
                list_b = new ListNode(0);
            }
        }

        return list_a;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(5);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(7);

        ListNode b = new ListNode(6);
        b.next = new ListNode(4);

        System.out.println(addTwoNumbers(a, b));
    }
}
