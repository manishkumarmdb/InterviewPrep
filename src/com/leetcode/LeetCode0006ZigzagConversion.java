package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0006ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows >= s.length())
            return s;
        String result = "";
        int row = 1;
        boolean isForward = true;
        Map<Integer, String> map = new HashMap<>();
        for (int i = 1; i <= s.length(); i++) {
            if (map.containsKey(row)) {
                map.put(row, map.get(row).concat("" + s.charAt(i - 1)));
            } else {
                map.put(row, "" + s.charAt(i - 1));
            }
            System.out.println("row is : " + row + " , dir : " + isForward + " , " + map);
            if (isForward) {
                row++;
                if (row > numRows) {
                    row = numRows - 1;
                    isForward = false;
                }
            } else {
                row--;
                if (row < 1) {
                    row = 2;
                    isForward = true;
                }
            }
        }
        row = 1;
        while (row <= numRows) {
            result += map.get(row++);
        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode0006ZigzagConversion obj = new LeetCode0006ZigzagConversion();
        String input = "PAYPALISHIRING";
        int row = 3;
        System.out.println(obj.convert(input, row));
    }
}
