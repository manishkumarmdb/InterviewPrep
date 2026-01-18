package com.leetcode;

import java.util.Arrays;

public class LeetCode0137SingleNumberII {

  private static int singleNumber(int[] nums) {
    /*
    * Bitwise State Machine Algorithm
    * We track how many times each bit has appeared modulo 3 using two integers:
    *   ones -> bits that have appeared once
    *   twos -> bits that have appeared twice
    * When a bit appears the third time, it gets cleared from both.
    * How it works intuitively
    * For each number:
    *   1. Update twos with bits that were already in ones
    *   2. Update ones by XOR-ing the current number
    *   3. Remove bits that appear three times from both ones and twos
    * At the end:
    *   ones contains the number that appeared exactly once
    * */
    int ones = 0;
    int twos = 0;
    for (int num : nums) {
      // Add num to twos if it already exists in ones
      twos |= ones & num;
      // XOR will add num to ones if not present, or remove it if present
      ones ^= num;
      // Remove bits that appear three times
      int commonMask = ~(ones & twos);
      ones &= commonMask;
      twos &= commonMask;
    }

    return ones;
  }

  public static void main(String[] args) {
    int[][] N = {{2,2,3,2}, {0,1,0,1,0,1,99}};
    Arrays.stream(N)
        .forEach(nums -> System.out.println(singleNumber(nums)));
  }
}
