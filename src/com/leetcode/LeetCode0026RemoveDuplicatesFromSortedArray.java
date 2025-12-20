package com.leetcode;

import java.util.Arrays;

public class LeetCode0026RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int countUnique = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != num) {
                nums[countUnique] = nums[i];
                countUnique++;
                num = nums[i];
            }
        }
        return countUnique;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        LeetCode0026RemoveDuplicatesFromSortedArray obj = new LeetCode0026RemoveDuplicatesFromSortedArray();
        System.out.println(obj.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
