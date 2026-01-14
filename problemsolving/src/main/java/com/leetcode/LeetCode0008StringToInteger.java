package com.leetcode;

import java.math.BigInteger;

public class LeetCode0008StringToInteger {

  private static int myAtoi_II(String s) {
    long result = 0;
    boolean isNeg = false;
    s = s.trim();
    // Handles sign, spaces, digits, stopping rules, and overflow
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (i == 0) {
        if (c == '-') {
          isNeg = true;
          continue;
        }
        if (c == '+') {
          continue;
        }
      }
      if (Character.isDigit(c)) {
        result = result * 10 + Character.getNumericValue(c);
      } else {
        break;
      }
      if (isNeg && result * -1 <= Integer.MIN_VALUE)
        return Integer.MIN_VALUE;
      else if (!isNeg && result > Integer.MAX_VALUE)
        return Integer.MAX_VALUE;
    }
    return isNeg ? (int) result * -1 : (int) result;
  }

  private static int myAtoi(String s) {
    //s = s.replaceAll("[\\s.]+", "");
    s = s.trim();
    //System.out.println("Input: " + s);
    String result = "";
    int sign = 1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if ((c == '-' || c == '+') && i > 0) {
        break;
      } else if (c == '-' && result.length() == 0) {
        sign = -1;
      } else if (c == '+' && result.length() == 0) {
        continue;
      } else if (Character.isDigit(c)) {
        result += c;
      } else {
        break;
      }
    }
    //System.out.println("Result: " + result + " sign: " + sign);
    if (result.length() == 0) return 0;
    BigInteger bi = new BigInteger(result).multiply(BigInteger.valueOf(sign));
    //System.out.println("New Result: " + bi);
    if (sign > 0) {
      BigInteger intMax = BigInteger.valueOf(Integer.MAX_VALUE);
      int intMaxComp = bi.compareTo(intMax);
      if (intMaxComp >= 0) {
        return Integer.MAX_VALUE;
      }
    } else {
      BigInteger intMin = BigInteger.valueOf(Integer.MIN_VALUE);
      int intMinComp = bi.compareTo(intMin);
      if (intMinComp <= 0) {
        return Integer.MIN_VALUE;
      }
    }

    return bi.intValue();
  }

  public static void main(String[] args) {
    String[] S = {"42", "-42", "  abd", " -042", "1337c0d3", "0-1", "3-2", "words and 987"};
    for (String str : S)
      System.out.println("\nInput: " + str + "\nResult: " + myAtoi_II(str));
  }
}
