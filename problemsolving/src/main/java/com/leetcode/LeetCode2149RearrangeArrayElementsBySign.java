package com.leetcode;

public class LeetCode2149RearrangeArrayElementsBySign {

  // Two-pointer alternating placement approach
  // Time: O(n), Space: O(n) for result array
  // Assumption: Equal number of positive and negative elements
  // Place positive numbers at even indices and negative numbers at odd indices
  // Example: [3,2,-5,1,6,-7] → [3,-5,2,-7,1,6]
  private static int[] rearrangeArray(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];

    int posIndex = 0;  // Index for placing positive numbers (0, 2, 4, ...)
    int negIndex = 1;  // Index for placing negative numbers (1, 3, 5, ...)

    for (int i = 0; i < n; i++) {
      if (nums[i] > 0) {
        // Place positive number at even position and move to next even position
        result[posIndex] = nums[i];
        posIndex += 2;  // Skip to next even index: 0→2→4→...
      } else {
        // Place negative number at odd position and move to next odd position
        result[negIndex] = nums[i];
        negIndex += 2;  // Skip to next odd index: 1→3→5→...
      }
    }

    return result;
  }
}
