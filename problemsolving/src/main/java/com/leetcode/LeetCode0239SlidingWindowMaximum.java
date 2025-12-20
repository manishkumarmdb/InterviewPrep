package com.leetcode;

import java.util.PriorityQueue;

public class LeetCode0239SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((o1, o2) -> (nums[o2] - nums[o1]));
        for (int i = 0; i < n; i++) {
            int diffIndex = i - k;
            if ( diffIndex >= 0)
                pqMax.remove(nums[diffIndex]);
            pqMax.offer(nums[i]);
            if (pqMax.size() == k)
                result[diffIndex + 1] = pqMax.peek();
        }
        return result;
    }
}
