package org.elvaston.leetcode;

import org.elvaston.leetcode.datastructures.ListNode;
import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.linked_list;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 *
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 */
@easy
@linked_list
public class delete_node_in_a_linked_list {

    /**
     * We only have the node to delete not the head.
     * Not really "deleting" just re-pointing and setting the value.
     * Also, don't need to worry about the TAIL and NULL as mentioned in the question notes
     */
    public void deleteNode(ListNode node) {
        ListNode tmp = node.next;
        node.next = tmp.next;
        node.val = tmp.val;
    }
}
