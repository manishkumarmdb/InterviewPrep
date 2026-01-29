package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0006ZigzagConversion {

  // Zigzag Conversion using HashMap approach
  // Time: O(n), Space: O(n) for storing characters in map
  // Arrange string in zigzag pattern with numRows, then read row by row
  // Example: "PAYPALISHIRING" with numRows=3:
  //   P   A   H   N
  //   A Y P L S I R I G
  //   Y   I   R
  // Result: "PAHNAYPLSIIGYIR"
  public String convert(String s, int numRows) {
    // Edge case: if rows >= string length, string stays as is
    if (numRows >= s.length())
      return s;
    
    String result = "";
    int row = 1;           // Current row (1 to numRows)
    boolean isForward = true;  // Direction: true = down, false = up
    Map<Integer, String> map = new HashMap<>();  // Store characters for each row
    
    // Traverse string character by character, placing in appropriate row
    for (int i = 1; i <= s.length(); i++) {
      char currentChar = s.charAt(i - 1);
      
      // Add character to current row
      if (map.containsKey(row)) {
        map.put(row, map.get(row).concat("" + currentChar));
      } else {
        map.put(row, "" + currentChar);
      }
      
      System.out.println("row is : " + row + " , dir : " + isForward + " , " + map);
      
      // Update row and direction (zigzag pattern)
      if (isForward) {
        // Moving down: increment row
        row++;
        if (row > numRows) {
          // Reached bottom, reverse direction
          row = numRows - 1;
          isForward = false;
        }
      } else {
        // Moving up: decrement row
        row--;
        if (row < 1) {
          // Reached top, reverse direction
          row = 2;
          isForward = true;
        }
      }
    }
    
    // Concatenate characters row by row to form result
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
