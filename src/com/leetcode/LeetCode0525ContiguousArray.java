package com.leetcode;

import java.util.Arrays;

public class LeetCode0525ContiguousArray {

    public int findMaxLength(int[] nums) {
        if (nums.length == 1) return 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                int[] subArray = Arrays.copyOfRange(nums, j, i + 1);
                if (isBinaryNumberEqual(subArray))
                    maxLength = Math.max(maxLength, subArray.length);
            }
        }
        return maxLength;
    }

    public static boolean isBinaryNumberEqual(int[] A) {
        int count = 0;
        for (int i : A) {
            if ( i == 1) count++;
            else count--;
        }
        return count == 0 ? true : false;
    }
}
