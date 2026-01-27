package com.leetcode;

public class LeetCode0378KthSmallestElementInASortedMatrix {

  // Binary Search on Value approach
  // Time: O(n log(max - min)), Space: O(1)
  // Search for the kth smallest value (not index) in sorted matrix
  // Matrix property: rows and columns are sorted (not diagonals)
  // Example: matrix=[[1,5,9],[10,11,13],[12,13,15]], k=8 -> return 13
  private static int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;

    // Binary search on the value range
    int low = matrix[0][0];              // Minimum value (top-left)
    int high = matrix[n - 1][n - 1];    // Maximum value (bottom-right)

    // Find the smallest value such that count of elements <= value >= k
    while (low < high) {
      int mid = low + (high - low) / 2;

      // Count how many elements are <= mid
      if (countLessEqual(matrix, mid) < k) {
        // Not enough elements <= mid, search higher values
        low = mid + 1;
      } else {
        // Enough elements <= mid, try to find smaller value
        high = mid;
      }
    }

    return low;
  }

  // Count elements <= target in sorted matrix using two-pointer technique
  // Time: O(n), Space: O(1)
  // Start from top-right or bottom-left to efficiently count
  // Using bottom-left: if element <= target, all elements above it in same column are included
  private static int countLessEqual(int[][] matrix, int target) {
    int n = matrix.length;
    int row = n - 1;  // Start from bottom row
    int col = 0;      // Start from leftmost column
    int count = 0;

    // Two-pointer traversal (like stairs)
    while (row >= 0 && col < n) {
      if (matrix[row][col] <= target) {
        // If current element <= target, all elements above it are also <= target
        // Count: row+1 elements (from row 0 to row inclusive)
        count += row + 1;
        col++;  // Move right to check next column
      } else {
        // Current element > target, move up to find smaller element
        row--;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
    int k = 8;
    System.out.println(kthSmallest(matrix, k));
  }
}
