package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.ListNode;
import org.elvaston.leetcode.tags.linked_list;
import org.elvaston.leetcode.tags.math;
import org.elvaston.leetcode.difficulty.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    public static ListNode addTwoNumbers(ListNode a, ListNode b) {
        Queue<Integer> s = new LinkedList<>();
        int sum = 0;
        while (a != null || b != null) {
            if (a != null) {
                sum += a.val;
                a = a.next;
            }
            if (b != null) {
                sum += b.val;
                b = b.next;
            }
            s.add(sum % 10);
            sum /= 10;
        }
        if (sum != 0) {
            s.add(sum);
        }

        ListNode n = new ListNode(-1);
        ListNode dummy = n;
        while (!s.isEmpty()) {
            dummy.next = new ListNode(s.remove());
            dummy = dummy.next;
        }
        return n.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(5);
//        a.next = new ListNode(2);
//        a.next.next = new ListNode(3);
//        a.next.next.next = new ListNode(7);

        ListNode b = new ListNode(5);
//        b.next = new ListNode(4);

        System.out.println(addTwoNumbers(a, b));
    }
}
