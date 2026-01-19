package com.leetcode;

public class LeetCode0009PalindromeNumber {

  /*
  * Reverse digits until the reversed number ≥ remaining number
  * Avoid full reversal
  * Avoid long
  * Prevent overflow automatically
  * */
  private static boolean isPalindrome(int x) {
    // negative numbers and numbers ending with 0 (except 0) are not palindrome
    if (x < 0 || (x % 10 == 0 && x != 0))
      return false;
    int reversedHalf = 0;
    while (x > reversedHalf) {
      System.out.println("x: " + x + "\nreversedHalf: " + reversedHalf);
      reversedHalf = reversedHalf * 10 + x % 10;
      x /= 10;
    }
    // For even length: x == reversedHalf
    // For odd length: x == reversedHalf / 10
    return x == reversedHalf || x == reversedHalf / 10;
  }

  public static void main(String[] args) {
    int x = 1234321;
    System.out.println("Input x: " + x);
    System.out.println("isPalindrome: " + isPalindrome(x));
  }
}
