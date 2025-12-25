package com.coderbyte;

import java.util.*;

public class MinWindowSubstring {

  private static String minWindowSubstring(String[] strArr) {
    // code goes here
    String N = strArr[0];
    String K = strArr[1];

    Map<Character, Integer> required = new HashMap<>();
    for (char c : K.toCharArray()) {
      required.put(c, required.getOrDefault(c, 0) + 1);
    }

    Map<Character, Integer> windowCounts = new HashMap<>();
    int have = 0, need = required.size();
    int left = 0, right = 0;
    int minLen = Integer.MAX_VALUE;
    int startIndex;

    String result = ""; // Result variable

    while (right < N.length()) {
      char c = N.charAt(right);
      windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

      if (required.containsKey(c) && windowCounts.get(c).intValue() == required.get(c).intValue()) {
        have++;
      }

      while (have == need) {
        // Update minimum window
        if (right - left + 1 < minLen) {
          minLen = right - left + 1;
          startIndex = left;
          result = N.substring(startIndex, startIndex + minLen);
        }

        char leftChar = N.charAt(left);
        windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
        if (required.containsKey(leftChar) && windowCounts.get(leftChar) < required.get(leftChar)) {
          have--;
        }
        left++;
      }
      right++;
    }
    return result;
  }

  public static void main(String[] args) {
    String[] input1 = {"ahffaksfajeeubsne", "jefaa"};
    System.out.println(minWindowSubstring(input1)); // Output: aksfaje

    String[] input2 = {"aaffhkksemckelloe", "fhea"};
    System.out.println(minWindowSubstring(input2)); // Output: affhkkse
  }

}
