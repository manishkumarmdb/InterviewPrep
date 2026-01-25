package com.leetcode;

public class LeetCode0724FindPivotIndex {
  // Prefix-Suffix Sum approach
  // Time: O(n), Space: O(1)
  // Find pivot index where sum of left elements = sum of right elements
  // Pivot is not included in either sum comparison
  // Example: [1,7,3,6,5,6] → pivot at index 3 (left sum=11, right sum=11)
  public int pivotIndex(int[] nums) {
    // Calculate total sum of all elements
    int totalSum = 0;
    for (int num : nums)
      totalSum += num;
    
    int leftSum = 0;   // Running sum of elements to the left of current index
    
    // Check each index as potential pivot
    for (int i = 0; i < nums.length; i++) {
      // Calculate right sum: total - current element - left sum
      // rightSum = sum of all elements to the right of index i
      int rightSum = totalSum - nums[i] - leftSum;
      
      // If left sum equals right sum, found the pivot
      if (leftSum == rightSum)
        return i;
      
      // Add current element to left sum for next iteration
      leftSum += nums[i];
    }
    
    // No pivot found
    return -1;
  }
}
