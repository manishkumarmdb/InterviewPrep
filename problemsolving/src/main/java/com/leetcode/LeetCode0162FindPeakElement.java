package com.leetcode;

public class LeetCode0162FindPeakElement {

  // Binary Search approach to find a peak element
  // Time: O(log n), Space: O(1)
  // Peak: Element greater than both neighbors (or at boundary)
  // Example: [1,2,3,1] → return 2 (value 3 is peak)
  //          [1,2,1] → return 1 (value 2 is peak)
  public int findPeakElement(int[] nums) {
    int n = nums.length;

    // Edge case: Single element is always a peak
    if (n == 1 || nums[0] > nums[1])
      return 0;

    // Edge case: Check if last element is peak (greater than second-last)
    if (nums[n - 1] > nums[n - 2])
      return n - 1;

    // Binary search in middle elements (guaranteed neighbors exist)
    int left = 1;
    int right = n - 2;

    while (left <= right) {
      int mid = (left + right) / 2;

      // Check if mid element is a peak
      if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
        return mid;

        // If mid > left neighbor, peak must be on right side
        // Reason: If ascending left, continue ascending right to find peak
      else if (nums[mid] > nums[mid - 1])
        left = mid + 1;

        // Otherwise, peak must be on left side
        // This includes descending or flat patterns
      else
        right = mid - 1;
    }

    return -1;  // Should not reach here with valid input
  }
}
