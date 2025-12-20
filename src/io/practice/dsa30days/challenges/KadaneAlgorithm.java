package io.practice.dsa30days.challenges;

// Given an integer array nums, find the subarray with the
//largest sum, and return its sum.

public class KadaneAlgorithm {

    public int largestSumContiguousSubarray(int[] num) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            currSum += num[i];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}
