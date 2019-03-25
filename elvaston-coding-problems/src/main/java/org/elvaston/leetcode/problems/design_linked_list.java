package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.linked_list;

/**
 * https://leetcode.com/problems/design-linked-list/
 *
 * Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node,
 * and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more
 * attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 * Implement these functions in your linked list class:
 *  - get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 *  - addAtHead(val) : Add a node of value val before the first element of the linked list.
 *    After the insertion, the new node will be the first node of the linked list.
 *  - addAtTail(val) : Append a node of value val to the last element of the linked list.
 *  - addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list.
 *    If index equals to the length of linked list, the node will be appended to the end of linked list.
 *    If index is greater than the length, the node will not be inserted.
 *  - deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 */
@easy
@linked_list
public class design_linked_list {
    class MyLinkedList {

        class Node {
            int val;
            Node next;
            Node(int val) {
                this.val = val;
            }
        }

        private Node root;
        private int size = 0;

        /** Initialize your data structure here. */
        public MyLinkedList() {

        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (index >= size) {
                return -1;
            }
            Node n = root;
            for (int i = 1; i <= index; i++) {
                n = n.next;
            }
            return n.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            size++;
            if (root == null) {
                root = new Node(val);
            } else {
                Node tmp = root;
                root = new Node(val);
                root.next = tmp;
            }
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            size++;
            Node tail = root;
            while (tail != null && tail.next != null) {
                tail = tail.next;
            }
            tail.next = new Node(val);
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }

            if (index == 0) {
                addAtHead(val);
            } else {
                size++;
                Node n = root;
                for (int i = 1; i < index; i++) {
                    n = n.next;
                }
                Node tmp = n.next;
                n.next = new Node(val);
                n.next.next = tmp;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (root != null && index == 0) {
                root = root.next;
                size--;
            } else if (index < size) {
                Node n = root;
                for (int i = 1; i < index; i++) {
                    n = n.next;
                }
                if (n.next != null) {
                    size--;
                    n.next = n.next.next;
                }
            }
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
