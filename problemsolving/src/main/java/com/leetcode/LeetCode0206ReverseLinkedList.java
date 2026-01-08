package com.leetcode;

public class LeetCode0206ReverseLinkedList {

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    private ListNode reverseList(ListNode head) {

        ListNode previousNode = null;
        while (head != null) {
            ListNode currentNode = head.next;
            head.next = previousNode;
            previousNode = head;
            head = currentNode;
        }
        return previousNode;
    }
}

