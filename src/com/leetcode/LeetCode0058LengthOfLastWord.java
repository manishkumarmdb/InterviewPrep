package com.leetcode;

public class LeetCode0058LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length > 0 && s.charAt(i) == ' ') {
                return length;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        LeetCode0058LengthOfLastWord obj = new LeetCode0058LengthOfLastWord();
        System.out.println(obj.lengthOfLastWord("   fly me   to   the moon  "));
    }
}
