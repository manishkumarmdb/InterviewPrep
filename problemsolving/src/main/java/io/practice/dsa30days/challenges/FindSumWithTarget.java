package io.practice.dsa30days.challenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Given an array of integers num and an integer target, return
//indices of the two numbers such that they add up to target.
public class FindSumWithTarget {

    private static final FindSumWithTarget INSTANCE = new FindSumWithTarget();

    public int[] findSumWithTarget(int[] num, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            int diff = target - num[i];
            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            } else {
                map.put(num[i], i);
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] num = new int[] {2,3,5,7,9,1};
        int target = 11;
        int[] output = FindSumWithTarget.INSTANCE.findSumWithTarget(num, target);
        System.out.println(Arrays.toString(output));
    }
}
