package com.leetcode;

import java.util.Arrays;

public class LeetCode1143LongestCommonSubsequence {

  // Approach 1: Recursive with Memoization (Top-Down DP)
  // Time: O(m * n), Space: O(m * n) for dp array + recursion stack
  // Find longest common subsequence by comparing characters from end
  // Example: "abcd" and "dbca" → LCS is "b" or "d" (length 1)
  private static int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    int[][] dp = new int[m + 1][n + 1];

    // Initialize dp table with -1 to mark unvisited states
    for (int[] row : dp)
      Arrays.fill(row, -1);

    return longestCommonSubsequence(m, n, text1, text2, dp);
  }

  // Recursive helper with memoization
  private static int longestCommonSubsequence(int m, int n, String text1, String text2, int[][] dp) {
    // Debug: print current DP state
    for (int[] _dp : dp)
      System.out.println(Arrays.toString(_dp));
    System.out.println("------------" + "\nm : " + m + "\nn : " + n + "\n------------");

    // Base case: if either string is empty, LCS length is 0
    if (m == 0 || n == 0)
      return 0;

    // Check if state already computed (memoization)
    if (dp[m][n] != -1)
      return dp[m][n];

    // Case 1: Characters match at current positions
    // Include this character and solve for rest: 1 + LCS(m-1, n-1)
    if (text1.charAt(m - 1) == text2.charAt(n - 1))
      return dp[m][n] = 1 + longestCommonSubsequence(m - 1, n - 1, text1, text2, dp);

    // Case 2: Characters don't match, take max of two options:
    // - Exclude current char from text1: LCS(m-1, n)
    // - Exclude current char from text2: LCS(m, n-1)
    return dp[m][n] = Math.max(longestCommonSubsequence(m - 1, n, text1, text2, dp),
        longestCommonSubsequence(m, n - 1, text1, text2, dp));
  }

  // Approach 2: Space-Optimized 1D DP (Bottom-Up)
  // Time: O(m * n), Space: O(m) - only single row needed
  // Process text2 character by character, update LCS for each position in text1
  // Example: "abcd" and "dbca" → length 1
  private static int longestCommonSubsequence_II(String text1, String text2) {
    int[] dp = new int[text1.length()];  // dp[i] = LCS length ending at text1[i]
    int longestLength = 0;

    // For each character in text2
    for (char ch : text2.toCharArray()) {
      int currentLength = 0;  // Track max LCS length seen in current iteration

      // Scan through text1 from left to right
      for (int i = 0; i < dp.length; i++) {
        // Save current dp[i] before updating
        if (currentLength < dp[i]) {
            currentLength = dp[i];
        }
        // If characters match, extend the LCS length
        else if (ch == text1.charAt(i)) {
          dp[i] = currentLength + 1;  // Extend previous best length
          longestLength = Math.max(longestLength, currentLength + 1);
        }
      }
    }

    return longestLength;
  }

  public static void main(String[] args) {
    String text1 = "abcd";
    String text2 = "dbca";
    System.out.println(longestCommonSubsequence_II(text1, text2));
  }
}
