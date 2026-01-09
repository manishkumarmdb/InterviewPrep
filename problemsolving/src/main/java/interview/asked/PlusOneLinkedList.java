package interview.asked;

public class PlusOneLinkedList {

  /*
    Steps:
    1. Reverse the list
    2. Add 1 while handling carry
    3. Reverse it back
    4. Add a new head node if carry still exists
  */
  private static class LinkedListNode {
    int val;
    LinkedListNode next;

    LinkedListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  private static LinkedListNode plusOne(LinkedListNode head) {
    // Step 1: Reverse the linked list
    head = reverse(head);

    // Step 2: Add one to the reversed list
    LinkedListNode current = head;
    int carry = 1;
    while (current != null && carry > 0) {
      int sum = current.val + carry;
      current.val = sum % 10;
      carry = sum / 10;
      if (current.next == null && carry > 0) {
        current.next = new LinkedListNode(0);
      }
      current = current.next;
    }

    // Step 3: Reverse back the list
    head = reverse(head);

    // Step 4: If carry remains, add new node at head
    if (carry > 0) {
      LinkedListNode newHead = new LinkedListNode(carry);
      newHead.next = head;
      head = newHead;
    }

    return head;
  }

  private static LinkedListNode reverse(LinkedListNode head) {
    LinkedListNode prev = null;
    while (head != null) {
      LinkedListNode curr = head.next;
      head.next = prev;
      prev = head;
      head = curr;
    }

    return prev;
  }

  private static void printLinkedList(LinkedListNode head) {
    while (head != null) {
      System.out.print(head.val);
      if (head.next != null) {
        System.out.print(" -> ");
      }
      head = head.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    LinkedListNode head1 = new LinkedListNode(4);
    head1.next = new LinkedListNode(5);
    head1.next.next = new LinkedListNode(8);
    head1.next.next.next = new LinkedListNode(7);
    printLinkedList(head1);
    head1 = plusOne(head1);
    printLinkedList(head1);

    LinkedListNode head2 = new LinkedListNode(9);
    head2.next = new LinkedListNode(9);
    printLinkedList(head2);
    head2 = plusOne(head2);
    printLinkedList(head2);
  }
}
