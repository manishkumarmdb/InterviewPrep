package com.leetcode;

public class LeetCode0053MaximumSubarray {

    public int maxSubArray(int[] nums) {
        long currentSum = 0;
        long maxSum = Integer.MIN_VALUE;
        int i = 0;
        while (i < nums.length) {
            currentSum += nums[i++];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0)
                currentSum = 0;
        }
        return (int) maxSum;
    }
}
