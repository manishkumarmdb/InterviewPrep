package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0003LongestSubstringWithoutRepeatingCharacters {

  // Sliding Window with HashMap approach
  // Time: O(n), Space: O(min(m, n)) where m = charset size, n = string length
  // Find the length of longest substring without repeating characters
  // Use sliding window with left and right pointers, hash map for character positions
  // Example: "abcabca" -> "abc" is longest (length 3)
  private static int lengthOfLongestSubstring(String s) {
    int maxLength = 0;     // Track maximum length found so far
    int left = 0;          // Left pointer of sliding window
    Map<Character, Integer> map = new HashMap<>();  // Store character -> last seen index

    // Expand window by moving right pointer
    for (int i = 0; i < s.length(); i++) {
      char currentChar = s.charAt(i);

      // If character exists in current window (index >= left), move left pointer
      if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
        // Move left pointer just after the previous occurrence of this character
        left = map.get(currentChar) + 1;
      } else {
        // No conflict, calculate length of current valid window
        maxLength = Math.max(maxLength, i - left + 1);
      }

      // Update character's most recent index
      map.put(currentChar, i);
    }

    return maxLength;
  }

  public static void main(String[] args) {
    String str = "abcabca";
    System.out.println(lengthOfLongestSubstring(str));
  }
}
