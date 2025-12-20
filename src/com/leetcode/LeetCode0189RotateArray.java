package com.leetcode;

import java.util.Arrays;

public class LeetCode0189RotateArray {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        for (; start < end;) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        LeetCode0189RotateArray obj = new LeetCode0189RotateArray();
        obj.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
