package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0078Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // Added empty list to the result
        for (int i = 0; i < nums.length; i++) {
            System.out.println("result i is : " + i + ", " + result);
            int size = result.size();
            System.out.println("current size is : " + size);
            for (int j = 0; j < size; j++) {
                List<Integer> subset = new ArrayList<>(result.get(j));
                System.out.println("nested subset j is : " + j + ", " + subset);
                subset.add(nums[i]);
                result.add(subset);
                System.out.println("nested result j is : " + j + ", " + result);
            }
        }
        System.out.println("result size : " + result.size());
        return result;
    }

    public List<List<Integer>> subsets_II(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                //check if the jth bit is set or not
                if ((i & (1 << j)) != 0)
                    subset.add(nums[j]);
            }
            if (subset.size() > 0)
                result.add(subset);
        }
        System.out.println("Total subset is : " + result.size());
        return result;
    }

    public List<List<Integer>> subsets_III(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets_III(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void subsets_III(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            subset.add(nums[i]);
            subsets_III(nums, i + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode0078Subsets obj = new LeetCode0078Subsets();
        int[] nums = new int[]{10,11,13};
        System.out.println(obj.subsets_III(nums));
        int n = 6;
        for (int i = 0; i < n; i++) {
            //check if the ith bit is set or not
            System.out.println((1 << i) + "," + (n & (1 << i)));
        }
    }
}
