package com.leetcode;

public class LeetCode0136SingleNumber {

    public static void main(String[] args) {
        LeetCode0136SingleNumber obj = new LeetCode0136SingleNumber();
        int[] nums = {1,2,1,1,4,3,3,4,};
        System.out.println(obj.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
            System.out.println("ans:" + ans);
        }
        return ans;
    }
}
