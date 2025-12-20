package com.leetcode;

public class LeetCode0387FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            chars[ch] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (chars[ch] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode0387FirstUniqueCharacterInAString obj = new LeetCode0387FirstUniqueCharacterInAString();
        String s = "leefvcvbngfetyuiycvtcoddgfhjfeescghjkezzz";
        System.out.println(obj.firstUniqChar(s));
    }
}
