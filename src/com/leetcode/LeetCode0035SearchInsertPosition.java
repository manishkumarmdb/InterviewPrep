package com.leetcode;

public class LeetCode0035SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        int mid = low + (high - low) / 2;
        while (low < high) {
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < low)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return  -1;
    }
}
