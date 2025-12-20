package com.leetcode;

import java.util.Arrays;

public class LeetCode0027RemoveElement {

    public int removeElement(int[] nums, int val) {
        int valCount = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val && nums[right] != val) {
                valCount++;
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            } else if ((nums[left] == val && nums[right] == val) || nums[right] == val) {
                right--;
                valCount++;
            }
            else if (nums[left] != val)
                left++;
        }
        System.out.println("valCount:" + valCount);

        return nums.length - valCount;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        LeetCode0027RemoveElement obj = new LeetCode0027RemoveElement();
        System.out.println(obj.removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }
}
