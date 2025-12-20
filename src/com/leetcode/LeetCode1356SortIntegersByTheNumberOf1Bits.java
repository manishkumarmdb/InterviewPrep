package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1356SortIntegersByTheNumberOf1Bits {

    public int[] sortByBits(int[] arr) {
        Integer[] _arr = new Integer[arr.length];
        Arrays.setAll(_arr, i -> arr[i]);
        Arrays.sort(_arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                int o1BitCount = Integer.bitCount(o1);
                int o2BitCount = Integer.bitCount(o2);
                if (o1BitCount == o2BitCount)
                    return o1 - o2;
                else
                    return o1BitCount - o2BitCount;
            }
        });
        Arrays.setAll(arr, i -> _arr[i]);
        return arr;
    }

    public static void main(String[] args) {
        //int[] arr = {0,1,2,3,4,5,6,7,8};
        int[] arr = {1024,512,256,128,64,32,16,8,4,2,1};
        LeetCode1356SortIntegersByTheNumberOf1Bits obj = new LeetCode1356SortIntegersByTheNumberOf1Bits();
        System.out.println(Arrays.toString(obj.sortByBits(arr)));
    }
}
