package com.leetcode;

public class LeetCode0074SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (target <= matrix[i][n - 1]) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    public boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode0074SearchA2DMatrix obj = new LeetCode0074SearchA2DMatrix();
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(obj.searchMatrix(matrix, target));
    }
}
