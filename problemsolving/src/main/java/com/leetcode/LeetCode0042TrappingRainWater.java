package com.leetcode;

public class LeetCode0042TrappingRainWater {

  // Two-Pointer Approach to Calculate Trapped Rainwater
  // Time: O(n), Space: O(1)
  // Water trapped at position i = min(leftMax, rightMax) - height[i]
  // Key: Move the pointer with smaller height to reduce search space
  // Example: height=[0,1,0,2,1,0,1,3,2,1,2,1] -> trapped water = 6
  public int trap(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int leftMax = height[left];    // Maximum height seen from left
    int rightMax = height[right];  // Maximum height seen from right
    int water = 0;                 // Total trapped water
    
    // Move pointers from both ends towards center
    while (left < right) {
      // If left max is smaller, process left side
      // Water trapped = leftMax - current height (since we know rightMax >= leftMax)
      if (leftMax < rightMax) {
        left++;
        // Update leftMax with current element
        leftMax = Math.max(leftMax, height[left]);
        // Add trapped water: the difference between max and current height
        water += leftMax - height[left];
      } else {
        // If right max is smaller or equal, process right side
        // Water trapped = rightMax - current height
        right--;
        // Update rightMax with current element
        rightMax = Math.max(rightMax, height[right]);
        // Add trapped water: the difference between max and current height
        water += rightMax - height[right];
      }
    }
    
    return water;
  }

  public static void main(String[] args) {
    LeetCode0042TrappingRainWater obj = new LeetCode0042TrappingRainWater();
    int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(obj.trap(height));
  }
}
