package com.leetcode;

public class LeetCode0070ClimbingStairs {
  // Dynamic Programming / Fibonacci relation
  // Time: O(n), Space: O(1)
  // Number of ways to climb n stairs when you can take 1 or 2 steps
  // Recurrence: ways(n) = ways(n-1) + ways(n-2)
  // Base: ways(1) = 1, ways(2) = 2
  // We compute iteratively using two variables to store previous two results
  private static int climbStairs(int n) {
    if (n == 1) {
      return 1; // Only one way: single step
    }
    int curr = 1; // ways for step i-1 (initially ways(1))
    int prev = 1; // ways for step i-2 (initially ways(0) treated as 1)
    // Iterate from step 2 up to n, updating curr and prev
    for (int i = 2; i <= n; i++) {
      int temp = curr; // store previous value
      curr += prev;    // ways(i) = ways(i-1) + ways(i-2)
      prev = temp;     // shift prev to previous ways(i-1)
    }
    return curr; // contains ways(n)
  }

  public static void main(String[] args) {
    int n = 3;
    System.out.println(climbStairs(n));
  }
}
