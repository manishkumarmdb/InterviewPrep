package com.leetcode;

public class LeetCode0206ReverseLinkedList {

  private static class ListNode {
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

  // Iterative Linked List Reversal using Three-Pointer Technique
  // Time: O(n), Space: O(1)
  // Reverse the direction of pointers in a singly linked list
  // Example: 1 -> 2 -> 3 -> null becomes null <- 1 <- 2 <- 3
  private static ListNode reverseList(ListNode head) {
    ListNode previousNode = null;  // Tracks reversed portion (initially null for last node)

    while (head != null) {
      // Step 1: Store next node before we change the link
      ListNode currentNode = head.next;

      // Step 2: Reverse the link - point current node to previous node
      head.next = previousNode;

      // Step 3: Move previous pointer to current node (grow reversed portion)
      previousNode = head;

      // Step 4: Move to next unprocessed node
      head = currentNode;
    }

    // previousNode now points to the new head (old tail)
    return previousNode;
  }

  private static void printLinkedList(ListNode head, boolean isReversed) {
    while (head != null) {
      System.out.print(head.val + (head.next != null ? (!isReversed ? " -> " : " <- ") : "\n"));
      head = head.next;
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4, null);
    printLinkedList(head, false);

    ListNode reversedLinkedList = reverseList(head);
    printLinkedList(reversedLinkedList, true);
  }
}

