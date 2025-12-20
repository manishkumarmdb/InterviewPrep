package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2006CountNumberOfPairsWithAbsoluteDifferenceK {

    public static int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            System.out.println(map);
            if(map.containsKey(nums[i] - k)){
                count += map.get(nums[i] - k);
            }
            if(map.containsKey(nums[i] + k)){
                count += map.get(nums[i] + k);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        System.out.println(countKDifference(nums, 1));
    }
}
