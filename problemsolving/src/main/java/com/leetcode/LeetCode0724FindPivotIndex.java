package com.leetcode;

public class LeetCode0724FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int totalSum = 0, leftSum = 0, rightSum = 0;
        for (int num : nums)
            totalSum += num;
        int i = 0, l = 0, r = nums.length - 1;
        while (i < nums.length) {
            rightSum = totalSum - nums[i] - leftSum;
            if (leftSum == rightSum)
                return i;
            leftSum += nums[i++];
        }
        return -1;
    }
}
