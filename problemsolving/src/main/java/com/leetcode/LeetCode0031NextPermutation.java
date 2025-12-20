package com.leetcode;

import java.util.Arrays;

public class LeetCode0031NextPermutation {

    public void nextPermutation(int[] nums) {
        int firstBreakPoint = -1;
        // step 1. find break point
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstBreakPoint = i;
                break;
            }
        }
        // if there is no break point just reverse the array
        if (firstBreakPoint == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            // step 2. find next greater element from nums[firstBreakPoint] and swap it
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[firstBreakPoint]) {
                    int curr = nums[i];
                    nums[i] = nums[firstBreakPoint];
                    nums[firstBreakPoint] = curr;
                    break;
                }
            }
            reverse(nums, firstBreakPoint + 1, nums.length - 1);
        }
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int curr = nums[start];
            nums[start++] = nums[end];
            nums[end--] = curr;
        }
    }

    public static void main(String[] args) {
        LeetCode0031NextPermutation obj = new LeetCode0031NextPermutation();
        int[] nums = new int[]{3,2,1};
        obj.nextPermutation(nums);
        //obj.reverse(nums, 2, 7);
        System.out.println(Arrays.toString(nums));
    }
}
