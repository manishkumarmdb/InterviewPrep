package com.leetcode;

import java.util.Arrays;

public class LeetCode0072EditDistance {
    /*
    https://leetcode.com/problems/edit-distance/description/
    https://medium.com/@greekykhs/leetcode-edit-distance-2bb38c3b56b2

    Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
    You have the following three operations permitted on a word:
    Insert a character
    Delete a character
    Replace a character

    Example 1:

    Input: word1 = "horse", word2 = "ros"
    Output: 3
    Explanation:
    horse -> rorse (replace 'h' with 'r')
    rorse -> rose (remove 'r')
    rose -> ros (remove 'e')
    Example 2:

    Input: word1 = "intention", word2 = "execution"
    Output: 5
    Explanation:
    intention -> inention (remove 't')
    inention -> enention (replace 'i' with 'e')
    enention -> exention (replace 'n' with 'x')
    exention -> exection (replace 'n' with 'c')
    exection -> execution (insert 'u')
    */

    public int stepCount(String input1, String input2) {
        int m = input1.length();
        int n = input2.length();
        int[][] dp = new int[m + 1][n + 1];
        // The value in the first row of ‘dp’ will be 0 to the length of word1
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        // The value in the column row of ‘dp’ will be 0 to the length of word2
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        System.out.println(Arrays.toString(dp[0]));
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (input1.charAt(i - 1) != input2.charAt(j - 1)) {
                    int insert = dp[i][j - 1];
                    int replace = dp[i - 1][j - 1];
                    int delete = dp[i - 1][j];
                    dp[i][j] = Math.min(insert, Math.min(replace, delete)) + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[m][n];
    }

    public int minDistance(String word1, String word2) {
        return stepCount(word1, word2);
    }

    public static void main(String[] args) {
        LeetCode0072EditDistance obj = new LeetCode0072EditDistance();
        String input1 = "horse";
        String input2 = "ros";
        System.out.println(obj.minDistance(input1, input2));
    }
}
