package com.leetcode;

public class LeetCode0050PowXN {

  // Fast Exponentiation using Binary Exponentiation (Exponentiation by Squaring)
  // Time: O(log n), Space: O(1)
  // Compute x^n efficiently by breaking down exponent into binary representation
  // Example: 2^10 = 2^(8+2) = 2^(1010 in binary)
  private static double myPow(double x, int n) {
    long N = n;  // Convert to long to safely handle Integer.MIN_VALUE (-2147483648)

    // Handle negative exponents: x^(-n) = 1 / x^n
    if (N < 0) {
      x = 1 / x;  // Reciprocal of base
      N = -N;     // Make exponent positive
    }

    double result = 1.0;

    // Binary exponentiation: process exponent bit by bit
    while (N > 0) {
      // If current bit is 1, multiply result by current power of x
      if (N % 2 == 1) {
        result *= x;
      }
      // Square the base for next bit position (x, x^2, x^4, x^8, ...)
      x *= x;
      // Right shift exponent to process next bit
      N /= 2;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(myPow(2.00000, -2147483648));
  }
}
