package com.leetcode;

import java.util.Vector;

public class LeetCode0300LongestIncreasingSubsequence {

  /*
   * Idea (Patience Sorting technique)
   * Maintain an array tails
   * tails[i] = smallest possible tail value of an increasing subsequence of length i + 1
   * For each number:
   *   Use binary search
   *   Replace the first element ≥ current number
   * The size of tails = LIS length
   * */
  // Patience Sorting + Binary Search approach
  // Time: O(n log n), Space: O(n)
  // Maintain 'tails' array where tails[i] = smallest tail of LIS with length i+1
  // For each number, use binary search to find position and replace it
  private static int lengthOfLIS(int[] nums) {
    int tails[] = new int[nums.length];
    int size = 0;

    for (int num : nums) {
      // Binary Search: Find first element >= num
      int left = 0, right = size;
      while (left < right) {
        int mid = (left + right) / 2;
        if (tails[mid] < num) {
          left = mid + 1;  // num is larger, search right
        } else {
          right = mid;     // num is smaller or equal, search left
        }
      }

      // Replace element at position 'left' with current num
      // This maintains the smallest possible tail values
      tails[left] = num;
      if (left == size) size++;  // Extended the LIS length
    }

    return size;
  }

  // Alternative approach using Vector and explicit lower bound search
  // Time: O(n log n), Space: O(n)
  private static int lengthOfLIS_II(int[] nums) {
    Vector<Integer> temp = new Vector<>();
    temp.add(nums[0]);
    int longestLength = 1;
    int length = nums.length;

    for (int i = 1; i < length; i++) {
      if (nums[i] > temp.lastElement()) {
        // Current number is greater than last, extend LIS
        temp.add(nums[i]);
        longestLength++;
      } else {
        // Current number is smaller, find position and replace
        // This keeps array sorted with smallest possible tail values
        int lowerBoundIndex = lowerBound(temp, nums[i]);
        temp.remove(lowerBoundIndex);
        temp.add(lowerBoundIndex, nums[i]);
      }
    }

    return longestLength;
  }

  // Binary search to find first element >= key in sorted vector
  private static int lowerBound(Vector<Integer> vector, int key) {
    int low = 0;
    int high = vector.size();

    while (low < high) {
      int mid = low + (high - low) / 2;

      // If element is less than key, search right half
      if (vector.get(mid) < key) {
        low = mid + 1;
      } else {
        // Move to left half to find first occurrence
        high = mid;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
    System.out.println(lengthOfLIS(nums));
    System.out.println(lengthOfLIS_II(nums));
  }
}
