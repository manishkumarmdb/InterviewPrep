package com.leetcode;

import java.util.Arrays;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
* */
public class LeetCode0080RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int countIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (countIndex == 0 || countIndex == 1 || nums[countIndex - 2] != nums[i]) {
                nums[countIndex] = nums[i];
                countIndex++;
            }
        }
        return countIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        LeetCode0080RemoveDuplicatesFromSortedArrayII obj = new LeetCode0080RemoveDuplicatesFromSortedArrayII();
        System.out.println(obj.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
