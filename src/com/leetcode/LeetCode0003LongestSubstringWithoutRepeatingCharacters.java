package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0003LongestSubstringWithoutRepeatingCharacters {

    private static final LeetCode0003LongestSubstringWithoutRepeatingCharacters INSTANCE =
            new LeetCode0003LongestSubstringWithoutRepeatingCharacters();

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= left)
                left = map.get(s.charAt(i)) + 1;
            else
                maxLength = Math.max(maxLength, i - left + 1);
            map.put(s.charAt(i), i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abcabca";
        System.out.println(INSTANCE.lengthOfLongestSubstring(str));
    }
}
