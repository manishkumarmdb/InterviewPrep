package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode0015ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // if the adjacent element is same then continue
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // initialize the j, k
            int j = i + 1;
            int k = nums.length - 1;
            // now check the all possible triplets i + j + k == 0
            while ( j < k) {
                int tipletSum = nums[i] + nums[j] + nums[k];
                if (tipletSum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                } else if (tipletSum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}
