package com.leetcode;

public class LeetCode0160IntersectionOfTwoLinkedLists {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }

    public ListNode getIntersectionNode_II(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        int len1 = 0;
        int len2 = 0;
        while (h1 != null || h2 != null) {
            if (h1 != null) {
                len1++;
                h1 = h1.next;
            }
            if (h2 != null) {
                len2++;
                h2 = h2.next;
            }
        }
        int diff = len1 - len2;
        if (diff > 0) {
            while (diff-- != 0) {
                headA = headA.next;
            }
        } else {
            while (diff++ != 0) {
                headB = headB.next;
            }
        }
        while (headA != null) {
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
