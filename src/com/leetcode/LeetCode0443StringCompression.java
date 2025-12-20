package com.leetcode;

public class LeetCode0443StringCompression {

    public int compress(char[] chars) {
        int count = 1;
        char ch = chars[0];
        String str = "";
        for (int i = 1; i < chars.length; i++) {
            if (ch != chars[i]) {
                str += ch + "" + (count > 1 ? count : "");
                count = 1;
                ch = chars[i];
            } else {
                count++;
            }
        }
        str += ch + "" + (count > 1 ? count : "");
        for(int i = 0; i < str.length(); i++){
            chars[i] = str.charAt(i);
        }
        return str.length();
    }

    public static void main(String[] args) {
        LeetCode0443StringCompression obj = new LeetCode0443StringCompression();
        char[] chars = new char[]{'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(obj.compress(chars));
    }
}
