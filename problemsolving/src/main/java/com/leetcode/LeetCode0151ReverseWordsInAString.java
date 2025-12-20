package com.leetcode;

public class LeetCode0151ReverseWordsInAString {

    public String reverseWords(String s) {
        s = s.trim();
        String[] _S = s.split("\\s+");
        s = "";
        for (int i = _S.length - 1; i >= 0; i--) {
            s += _S[i]  + " ";
        }
        return s.substring(0, s.length() - 1);
    }

    public String _reverseWords(String s) {
        s = trim(s);
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            s = s.substring(0, i)
                    + s.charAt(length - i - 1)
                    + s.substring(i + 1, length - i - 1)
                    + s.charAt(i)
                    + s.substring(length - i);
        }
        return s;
    }

    public String trim(String s) {
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        boolean leftFlag = true;
        boolean rightFlag = true;
        while (true) {
            if (s.charAt(leftIndex) == ' ' && leftFlag) {
                leftIndex++;
            } else {
                leftFlag = false;
            }
            if (s.charAt(rightIndex) == ' ' && rightFlag) {
                rightIndex--;
            } else {
                rightFlag = false;
            }
            if (!leftFlag && !rightFlag) {
                break;
            }

        }
        return s.substring(leftIndex, rightIndex + 1);
    }

    public static void main(String[] args) {
        LeetCode0151ReverseWordsInAString obj = new LeetCode0151ReverseWordsInAString();
        System.out.println(obj.reverseWords("the sky is blue"));
    }
}
