package com.hackerrank.att;

import java.util.Arrays;

public class MinimumAlternatingFlips {

  // Single-Pass Minimum Flips for Alternating Pattern
  // Time: O(n), Space: O(1)
  // Find minimum flips needed to make string alternating
  // Can start with either '0' or '1', pick the one requiring fewer flips
  // Example: "11101" -> start with 0: [0,1,0,1,0] needs 2 flips
  //                    start with 1: [1,0,1,0,1] needs 3 flips -> return 2
  private static int minFlip(String str) {
    int flipStartWith0 = 0;  // Count of flips needed if pattern starts with '0'
    int flipStartWith1 = 0;  // Count of flips needed if pattern starts with '1'

    // Single pass: for each position, check both alternating patterns
    for (int i = 0; i < str.length(); i++) {
      // Expected character if pattern starts with '0': 0,1,0,1,0,...
      char expected0 = i % 2 == 0 ? '0' : '1';

      // Expected character if pattern starts with '1': 1,0,1,0,1,...
      char expected1 = i % 2 == 0 ? '1' : '0';

      char curr_char = str.charAt(i);

      // If current char doesn't match pattern starting with '0', need a flip
      if (curr_char != expected0) {
        flipStartWith0++;
      }

      // If current char doesn't match pattern starting with '1', need a flip
      if (curr_char != expected1) {
        flipStartWith1++;
      }
    }

    // Return the minimum flips required
    return Math.min(flipStartWith0, flipStartWith1);
  }

  public static void main(String[] args) {
    String[] S = {"11101", "111101", "01010"};
    Arrays.stream(S)
      .forEach(str -> System.out.println(minFlip(str)));
  }
}
