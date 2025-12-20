package com.leetcode;

import java.util.Arrays;

public class LeetCode1143LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        // initialize default value to -1
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return longestCommonSubsequence(m, n, text1, text2, dp);
    }

    private int longestCommonSubsequence(int m, int n, String text1, String text2, int[][] dp) {
        //print the dp
        for (int[] _dp : dp)
            System.out.println(Arrays.toString(_dp));
        System.out.println("------------" + "\nm : " + m + "\nn : " + n + "\n------------");
        if (m == 0 || n == 0)
            return 0;
        //check the state has been visited or not
        if (dp[m][n] != -1)
            return dp[m][n];
        if (text1.charAt(m - 1) == text2.charAt(n - 1))
            return dp[m][n] = 1 + longestCommonSubsequence(m - 1, n - 1, text1, text2, dp);
        return dp[m][n] = Math.max(longestCommonSubsequence(m - 1, n, text1, text2, dp),
                longestCommonSubsequence(m, n - 1, text1, text2, dp));
    }

    public int longestCommonSubsequence_II(String text1, String text2) {
        int[] dp = new int[text1.length()];
        int longestLength = 0;
        for (char ch : text2.toCharArray()) {
            int currentLength = 0;
            for (int i = 0; i < dp.length; i++) {
                if (currentLength < dp[i])
                    currentLength = dp[i];
                else if (ch == text1.charAt(i)) {
                    dp[i] = currentLength + 1;
                    longestLength = Math.max(longestLength, currentLength + 1);
                }
            }
        }

        return longestLength;
    }

    public static void main(String[] args) {
        LeetCode1143LongestCommonSubsequence obj = new LeetCode1143LongestCommonSubsequence();
        String text1 = "abcd";
        String text2 = "dbca";
        System.out.println(obj.longestCommonSubsequence_II(text1, text2));
    }
}
