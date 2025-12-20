package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LeetCode0229MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        int majority1 = 0, majority2 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == majority1)
                count1++;
            else if (num == majority2)
                count2++;
            else if (count1 == 0) {
                majority1 = num;
                count1++;
            } else if (count2 == 0) {
                majority2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        //
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == majority1)
                count1++;
            else if (num == majority2)
                count2++;
        }
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        if (count1 > n / 3)
            result.add(majority1);
        if (count2 > n / 3)
            result.add(majority2);

        return result;
    }
    public List<Integer> majorityElement_II(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > nums.length / 3)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        LeetCode0229MajorityElementII obj = new LeetCode0229MajorityElementII();
        int[] nums = {1,2,3,4,5,4,3,4,4};
        System.out.println(obj.majorityElement(nums));
    }
}
