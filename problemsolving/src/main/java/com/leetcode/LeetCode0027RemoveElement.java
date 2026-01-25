package com.leetcode;

import java.util.Arrays;

public class LeetCode0027RemoveElement {

  // Two-Pointer In-Place Removal
  // Time: O(n), Space: O(1)
  // Remove all occurrences of val and return new length
  // Modifies array in-place, first k elements contain non-val elements
  // Example: nums=[3,2,2,3], val=3 → return 2, nums becomes [2,2,2,3] (first 2 elements are answer)
  private static int removeElement(int[] nums, int val) {
    int n = nums.length;
    int i = 0;  // Pointer to scan through array
    int j = 0;  // Pointer to place non-val elements
    
    while (i < n) {
      // If current element is not the value to remove
      if (nums[i] != val) {
        // Copy non-val element to position j
        nums[j] = nums[i];
        j++;  // Move write pointer forward
      }
      i++;  // Always move scan pointer forward
    }
    
    // j represents the count of elements that are not equal to val
    return j;
  }

  public static void main(String[] args) {
    int[] nums = {3, 2, 2, 3};
    int val = 3;
    System.out.println(removeElement(nums, val));
    System.out.println(Arrays.toString(nums));
  }
}
