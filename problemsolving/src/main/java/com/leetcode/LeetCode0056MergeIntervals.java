package com.leetcode;

import java.util.Arrays;

public class LeetCode0056MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][0] = -1;
                count++;
            }
        }
        int[][] result = new int[intervals.length - count][2];
        int[] interval = intervals[0];
        int r = 0;
        result[r] = interval;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] == -1) {
                interval[1] = intervals[i][1];
            } else if (intervals[i][0] != -1) {
                result[r++] = interval;
                interval = intervals[i];
            }
        }
        result[r++] = interval;
        return result;
    }

    public static void main(String[] args) {
        LeetCode0056MergeIntervals obj = new LeetCode0056MergeIntervals();
        //int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{12,18}};
        //int[][] intervals = new int[][]{{1,4},{4,5}};
        int[][] intervals = new int[][]{{1,4},{0,4}};
        int[][] result = obj.merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
