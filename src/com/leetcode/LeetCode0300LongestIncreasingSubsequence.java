package com.leetcode;

import java.util.Vector;

public class LeetCode0300LongestIncreasingSubsequence {

    public int lowerBound(Vector<Integer> vector, int key) {
        int low = 0;
        int high = vector.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If arr[mid] is less than key, move to the right half
            if (vector.get(mid) < key) {
                low = mid + 1;
            } else {
                // Move to the left half, because we want the first occurrence or the exact position
                high = mid;
            }
        }
        return low;
    }

    public int lengthOfLIS(int[] nums) {
        Vector<Integer> temp = new Vector<>();
        temp.add(nums[0]);
        int longestLength = 1;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] > temp.lastElement()) {
                temp.add(nums[i]);
                longestLength++;
            } else {
                int lowerBoundIndex = lowerBound(temp, nums[i]);
                temp.remove(lowerBoundIndex);
                temp.add(lowerBoundIndex, nums[i]);
            }
        }

        return longestLength;
    }

    public static void main(String[] args) {
        LeetCode0300LongestIncreasingSubsequence obj =
                new LeetCode0300LongestIncreasingSubsequence();
        int nums[] = {10,9,2,5,3,7,101,18};
        System.out.println(obj.lengthOfLIS(nums));
    }
}
