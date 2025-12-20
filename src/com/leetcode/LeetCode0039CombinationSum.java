package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0039CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum(int[] candidates, int target, int index, ArrayList<Integer> temp, List<List<Integer>> result) {
        if (index == candidates.length) {
            if (target == 0)
                result.add(new ArrayList<>(temp));
            return;
        }
        if (candidates[index] <= target) {
            temp.add(candidates[index]);
            combinationSum(candidates, target - candidates[index], index, temp, result);
            temp.remove(temp.size() - 1);
        }
        combinationSum(candidates, target, index + 1, temp, result);
    }
}
