package com.leetcode;

public class LeetCode0367ValidPerfectSquare {

  private static boolean isPerfectSquare(int num) {
    // If num is 0 or 1, it is a perfect square
    if (num < 2) return true;

    // Binary search range
    // Start from 2 because 0 and 1 are already handled
    long left = 2;
    // Maximum possible sqrt of num is num/2 (for num > 1)
    long right = num / 2;

    while (left <= right) {
      // Use safe mid calculation to avoid overflow:
      // mid = left + (right - left) / 2
      long mid = left + (right - left) / 2;

      // square = mid * mid
      // Use long to prevent overflow for large num
      long square = mid * mid;

      // If square equals num, num is a perfect square
      if (square == num) {
        return true;
      }
      // If square is less than num, we need to search in the right half
      else if (square < num) {
        left = mid + 1;
      }
      // If square is greater than num, we need to search in the left half
      else {
        right = mid - 1;
      }
    }

    // If we exit the loop, num is not a perfect square
    return false;
  }
}
