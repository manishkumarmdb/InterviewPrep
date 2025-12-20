package com.leetcode;

public class LeetCode0152MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int leftProduct = 1;
        int rightProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            if (leftProduct == 0)
                leftProduct = 1;
            if (rightProduct == 0)
                rightProduct = 1;
            leftProduct *= nums[i];
            rightProduct *= nums[nums.length - i - 1];
            maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
        }
        return maxProduct;
    }

    public int maxProduct_II(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            result = Math.max(max, result);
        }
        return result;
    }
}
