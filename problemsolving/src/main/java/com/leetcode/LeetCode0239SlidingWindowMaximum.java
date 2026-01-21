package com.leetcode;

import java.util.PriorityQueue;

public class LeetCode0239SlidingWindowMaximum {

  // Max Heap approach for Sliding Window Maximum
  // Time: O(n log k), Space: O(k)
  // Maintain a max heap of elements in current window
  // For each position, remove old elements and add new one, return heap max
  // Example: nums=[1,3,-1,-3,5,3,6,7], k=3 -> [3,3,5,5,6,7]
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int[] result = new int[n - k + 1];  // Result array size: n - k + 1

    // Max heap comparing by array values (descending order)
    PriorityQueue<Integer> pqMax = new PriorityQueue<>((o1, o2) -> (nums[o2] - nums[o1]));

    for (int i = 0; i < n; i++) {
      // Calculate the index of element leaving the window
      int diffIndex = i - k;

      // Remove element that's outside the window (too old)
      if (diffIndex >= 0)
        pqMax.remove(nums[diffIndex]);

      // Add current element to the window
      pqMax.offer(nums[i]);

      // When window is full (size == k), record the maximum element
      if (pqMax.size() == k)
        result[diffIndex + 1] = pqMax.peek();
    }

    return result;
  }
}
