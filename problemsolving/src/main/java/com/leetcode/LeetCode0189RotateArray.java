package com.leetcode;

import java.util.Arrays;

public class LeetCode0189RotateArray {

  // Reverse-based array rotation approach
  // Time: O(n), Space: O(1)
  // Idea: Reverse three segments to achieve rotation without extra space
  // Example: [1,2,3,4,5,6,7] rotated by 3 → [5,6,7,1,2,3,4]
  private static void rotate(int[] nums, int k) {
    // Handle k greater than array length
    k %= nums.length;

    // Step 1: Reverse entire array
    // [1,2,3,4,5,6,7] → [7,6,5,4,3,2,1]
    reverse(nums, 0, nums.length - 1);

    // Step 2: Reverse first k elements
    // [7,6,5,4,3,2,1] → [5,6,7,4,3,2,1]
    reverse(nums, 0, k - 1);

    // Step 3: Reverse remaining elements
    // [5,6,7,4,3,2,1] → [5,6,7,1,2,3,4]
    reverse(nums, k, nums.length - 1);
  }

  // Helper method to reverse array elements between start and end indices
  private static void reverse(int[] nums, int start, int end) {
    for (; start < end; ) {
      // Swap elements at start and end positions
      int temp = nums[start];
      nums[start++] = nums[end];
      nums[end--] = temp;
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    rotate(nums, k);
    System.out.println(Arrays.toString(nums));
  }
}
