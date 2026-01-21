package com.leetcode;

public class LeetCode0152MaximumProductSubarray {

  // Approach 1: Left-Right Product Scan
  // Time: O(n), Space: O(1)
  // Scan left-to-right and right-to-left tracking product, reset on zeros
  // Works because max product must end at some position or start from some position
  public int maxProduct(int[] nums) {
    int maxProduct = Integer.MIN_VALUE;
    int leftProduct = 1;      // Product scanning from left to right
    int rightProduct = 1;     // Product scanning from right to left

    for (int i = 0; i < nums.length; i++) {
      // Reset products to 1 when encountering 0 (breaks the chain)
      if (leftProduct == 0)
        leftProduct = 1;
      if (rightProduct == 0)
        rightProduct = 1;

      // Calculate products in both directions
      leftProduct *= nums[i];
      rightProduct *= nums[nums.length - i - 1];

      // Track maximum product from both directions
      maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
    }
    return maxProduct;
  }

  // Approach 2: Dynamic Programming - Track Min/Max at Each Position
  // Time: O(n), Space: O(1)
  // Keep track of both max and min products ending at each position
  // Min matters because negative * negative = positive (could become max)
  public int maxProduct_II(int[] nums) {
    int max = nums[0];        // Max product ending at current position
    int min = nums[0];        // Min product ending at current position (often negative)
    int result = nums[0];     // Overall maximum product found so far

    for (int i = 1; i < nums.length; i++) {
      // Save previous max before overwriting (needed for min calculation)
      int temp = max;

      // Max at position i: max of (prev_max*num, prev_min*num, num_alone)
      // Include nums[i] alone in case previous products were negative
      max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);

      // Min at position i: min of (prev_max*num, prev_min*num, num_alone)
      // Track minimum because it could become maximum when multiplied by next negative
      min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);

      // Update overall result
      result = Math.max(max, result);
    }
    return result;
  }
}
