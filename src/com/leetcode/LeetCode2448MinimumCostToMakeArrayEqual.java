package com.leetcode;

public class LeetCode2448MinimumCostToMakeArrayEqual {

    public long minCost(int[] nums, int[] cost) {
        int max = 0, min = 1000001;
        long ans = 0, total = 0, stepleft = 0, stepright = 0;
        long[] t = new long[1000001];

        for (int i = 0; i != nums.length; i++) {
            stepright += cost[i];
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
            t[nums[i]] += cost[i];
        }

        for (int i = 0; i != nums.length; i++)
            total += (nums[i] - min) * (long) cost[i];

        ans = total;
        for (int i = min; i != max; i++) {
            stepleft += t[i];
            stepright -= t[i];
            total += stepleft - stepright;
            if (ans > total) ans = total;
            else break;
        }

        return ans;
    }
}
