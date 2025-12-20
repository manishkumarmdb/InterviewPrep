package com.leetcode;

public class LeetCode3168MinimumNumberOfChairsInAWaitingRoom {
    public int minimumChairs(String s) {
        int count = 0;
        int maxChairNeeded = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if ('E' ==s.charAt(i)) {
                count++;
                maxChairNeeded = Math.max(maxChairNeeded, count);
            } else {
                count--;
            }
        }
        return maxChairNeeded;
    }
}
