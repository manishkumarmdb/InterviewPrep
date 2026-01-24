package com.leetcode;

public class LeetCode0876MiddleOfTheLinkedList {

  private class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  // Tortoise and Hare (Two-Pointer) approach
  // Time: O(n), Space: O(1)
  // Fast pointer moves 2 steps, slow pointer moves 1 step
  // When fast reaches end, slow is at the middle
  // For even length: returns first node of second half
  // For odd length: returns the exact middle node
  // Example: 1 -> 2 -> 3 -> 4 -> 5 -> returns 3
  //          1 -> 2 -> 3 -> 4 -> returns 3
  public ListNode middleNode(ListNode head) {
    ListNode slow = head;  // Moves 1 step at a time
    ListNode fast = head;  // Moves 2 steps at a time

    // Continue until fast pointer reaches the end
    // fast != null: checks if fast can move further
    // fast.next != null: checks if fast can move 2 steps
    // slow != null: ensures slow pointer is valid
    while (fast != null && fast.next != null && slow != null) {
      fast = fast.next.next;  // Move fast pointer by 2 nodes
      slow = slow.next;       // Move slow pointer by 1 node
    }

    // When fast reaches end, slow is at middle
    return slow;
  }
}


