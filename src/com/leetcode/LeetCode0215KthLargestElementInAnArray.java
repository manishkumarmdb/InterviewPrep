package com.leetcode;

import java.util.PriorityQueue;

public class LeetCode0215KthLargestElementInAnArray {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : nums) {
            minHeap.offer(i);
            System.out.println("current heap : " + minHeap);
            if (minHeap.size() > k) {
                System.out.println("going to be delete : " + minHeap.peek());
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}
