package com.leetcode;

import java.util.PriorityQueue;

public class LeetCode0215KthLargestElementInAnArray {

  // Min-Heap approach to find Kth largest element
  // Time: O(n log k), Space: O(k)
  // Maintain a min heap of size k with k largest elements
  // The root of the heap is always the kth largest element
  private static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    for (int i : nums) {
      minHeap.offer(i);  // Add current element to heap
      // System.out.println("current heap : " + minHeap);
      
      // Keep heap size at k by removing smallest element
      // This ensures we maintain only k largest elements
      if (minHeap.size() > k) {
        // System.out.println("going to be delete : " + minHeap.peek());
        minHeap.poll();  // Remove min element (smallest of k largest)
      }
    }
    
    // Root of min heap with k elements = kth largest
    return minHeap.peek();
  }

  public static void main(String[] args) {
    int[] nums = {3, 2, 1, 5, 6, 4};
    int k = 2;
    System.out.println(findKthLargest(nums, k));
  }
}
