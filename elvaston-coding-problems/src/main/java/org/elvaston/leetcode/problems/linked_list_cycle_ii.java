package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.ListNode;
import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.linked_list;
import org.elvaston.leetcode.tags.two_pointers;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 */
@medium
@linked_list
@two_pointers
public class linked_list_cycle_ii {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != null && fast != null && fast.next != null && slow != fast);

        fast = head;
        while (fast != slow && slow != null && fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
