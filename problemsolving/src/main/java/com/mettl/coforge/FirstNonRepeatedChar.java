package com.mettl.coforge;

import java.util.LinkedHashMap;
import java.util.Map;

// Find the first non-repeated character in a given string
// Input string contains only lowercase letters
public class FirstNonRepeatedChar {

  private static String firstNonRepeatedChar(String str) {
    Map<Character, Integer> map = new LinkedHashMap<>();
    for (char ch : str.toCharArray())
      map.put(ch, map.getOrDefault(ch, 0) + 1);

    String result = "";
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        result += entry.getKey();
        return result;
      }
    }

    return result;
  }

  private static String firstNonRepeatedChar_II(String str) {
    int[] C = new int[26];
    for (char ch : str.toCharArray()) {
      C[ch - 'a'] = C[ch - 'a'] + 1;
    }

    for (char ch : str.toCharArray()) {
      if (C[ch - 'a'] == 1)
        return String.valueOf(ch);
    }
    return "";
  }

  public static void main(String[] args) {
    String str = "mannishkumar";
    System.out.println(firstNonRepeatedChar(str));
    System.out.println(firstNonRepeatedChar_II(str));
  }
}
