package com.leetcode;

public class LeetCode0921MinimumAddToMakeParenthesesValid {

  private static int minAddToMakeValid(String s) {
    int openBrackets = 0;
    int closeBrackets = 0;
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        openBrackets++;
      } else {
        if (openBrackets > 0) {
          openBrackets--;
        } else {
          closeBrackets++;
        }
      }
    }

    return openBrackets + closeBrackets;
  }

  public static void main(String[] args) {
    String s = "(((";
    System.out.println(minAddToMakeValid(s));
  }

}
