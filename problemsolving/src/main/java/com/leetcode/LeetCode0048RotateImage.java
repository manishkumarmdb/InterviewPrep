package com.leetcode;

import java.util.Arrays;

public class LeetCode0048RotateImage {

  private static void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int r = 0; r < n; r++) {
      // Transpose the matrix
      int c = r;
      while (c < n) {
        int curr_rc = matrix[r][c];
        matrix[r][c] = matrix[c][r];
        matrix[c][r] = curr_rc;
        c++;
      }
      // Reverse the current row
      int left = 0, right = n - 1;
      while (left < right) {
        matrix[r][left] = matrix[r][left] ^ matrix[r][right];
        matrix[r][right] = matrix[r][left] ^ matrix[r][right];
        matrix[r][left] = matrix[r][left] ^ matrix[r][right];
        left++;
        right--;
      }
    }
  }

  public static void main(String[] args) {
    /*
    * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    * Output: [[7,4,1],[8,5,2],[9,6,3]]
    *
    * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
    * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    * */
    int[][] matrix = {{1,2,3}, {4,5,6},{7,8,9}};
    System.out.println("Input:");
    Arrays.stream(matrix)
        .forEach(m -> System.out.println(Arrays.toString(m)));
    // call function
    rotate(matrix);
    System.out.println("Output:");
    Arrays.stream(matrix)
        .forEach(m -> System.out.println(Arrays.toString(m)));
  }
}
