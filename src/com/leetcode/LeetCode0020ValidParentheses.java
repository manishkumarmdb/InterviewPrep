package com.leetcode;

import java.util.Stack;

public class LeetCode0020ValidParentheses {

    public boolean isValid(String s) {
        if (")}]".contains(Character.toString(s.charAt(0))))
            return false;
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!charStack.isEmpty()
                    && ((ch == ')' && charStack.peek() == '(')
                    || (ch == '}' && charStack.peek() == '{')
                    || (ch == ']' && charStack.peek() == '['))) {
                charStack.pop();
            } else {
                charStack.push(ch);
            }
        }
        return charStack.isEmpty();
    }

    public boolean isValid_II(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                stack.push(')');
            else if (ch == '{')
                stack.push('}');
            else if (ch == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != ch)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode0020ValidParentheses obj = new LeetCode0020ValidParentheses();
        String input = "([]){}";
        System.out.println(obj.isValid_II(input));
    }
}
