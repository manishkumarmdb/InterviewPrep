package com.leetcode;

import java.util.Arrays;

public class LeetCode0088MergeSortedArray {

  // Reverse Two-Pointer Merge Approach
  // Time: O(m + n), Space: O(1)
  // Merge two sorted arrays into nums1 in-place
  // nums1 has enough space (size m+n) to hold both arrays
  // Key: Start from the end of both arrays to avoid overwriting unprocessed elements
  // Example: nums1=[1,2,3,0,0,0] (m=3), nums2=[2,5,6] (n=3) -> nums1=[1,2,2,3,5,6]
  private static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;      // Pointer to last actual element in nums1
    int j = n - 1;      // Pointer to last element in nums2
    int k = m + n - 1;  // Pointer to last position in nums1 (where merged result goes)

    // Compare and place larger element from either array
    while (i >= 0 && j >= 0) {
      if (nums1[i] > nums2[j]) {
        // nums1[i] is larger, place it at position k
        nums1[k] = nums1[i];
        i--;
      } else {
        // nums2[j] is larger or equal, place it at position k
        nums1[k] = nums2[j];
        j--;
      }
      k--;  // Move to previous position in result array
    }

    // Copy remaining elements from nums2 (if any)
    // Note: No need to copy remaining nums1 elements since they're already in place
    while (j >= 0) {
      nums1[k] = nums2[j];
      j--;
      k--;
    }
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    int m = 3, n = 3;
    merge(nums1, m, nums2, n);
    System.out.println(Arrays.toString(nums1));
  }
}
