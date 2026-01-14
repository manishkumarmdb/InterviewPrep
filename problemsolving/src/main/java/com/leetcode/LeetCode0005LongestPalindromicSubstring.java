package com.leetcode;

public class LeetCode0005LongestPalindromicSubstring {

  private static String longestPalindrome(String s) {
    /*
    * A palindrome expands symmetrically around its center.
    * A center can be:
    *   One character (odd-length palindrome)
    *   Two characters (even-length palindrome)
    * For each index, expand both ways and track the longest palindrome.
    * */
    int start = 0; // starting index of longest palindrome
    int maxLen = 1; // length of longest palindrome
    for (int i = 0; i < s.length(); i++) {
      int oddLen = expandFromCenter(s, i, i);
      int evenLen = expandFromCenter(s, i, i + 1);
      int currLen = Math.max(oddLen, evenLen);
      if (currLen > maxLen) {
        maxLen = currLen;
        start = i - (currLen - 1) / 2;
      }
    }
    return s.substring(start, start + maxLen);
  }

  private static int expandFromCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1; // length of palindrome
  }

  public static void main(String[] args) {
    String[] S = {"babad", "cbbd", "a"};
    for (String str : S) {
      System.out.println(longestPalindrome(str));
    }
  }

}
