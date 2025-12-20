package com.leetcode;
/*
* https://leetcode.com/problems/first-letter-to-appear-twice/description/
* */
public class LeetCode2351FirstLetterToAppearTwice {

    public char repeatedCharacter(String s) {
        int[] C = new int[26 + 1];
        int i = 0;
        while (i < s.length()) {
            int ch = s.charAt(i++) - 97 + 1;
            if (C[ch] == 0)
                C[ch] = ch;
            else
                break;
        }
        return s.charAt(i - 1);
    }

    public static void main(String[] args) {
        LeetCode2351FirstLetterToAppearTwice obj = new LeetCode2351FirstLetterToAppearTwice();
        String str = "dgresfgr";
        System.out.println(obj.repeatedCharacter(str));
    }
}
