package org.takeuforward.strivers79;

public class FindMiddleElementInALinkedList {

  private static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  private static Node findMiddle(Node head) {
    // Initialize the slow pointer to the head.
    Node slow = head;
    // Initialize the fast pointer to the head.
    Node fast = head;

    // Traverse the linked list using the Tortoise and Hare algorithm.
    while (slow != null && fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    // Return the slow pointer, which is now at the middle node.
    return slow;

  }

  public static void main(String[] args) {
    // Creating a sample linked list:
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = new Node(6);

    // Find the middle node
    Node middleNode = findMiddle(head);

    // Display the value of the middle node
    System.out.println("The middle node value is: " + middleNode.data);
  }
}
