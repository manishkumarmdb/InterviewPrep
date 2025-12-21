package com.coderbyte;

public class CodelandUsernameValidation {

    private static String CodelandUsernameValidation(String str) {
        // code goes here
        if (str.length() < 4
                || str.length() > 25
                || !Character.isLetter(str.charAt(0))
                || str.charAt(str.length() - 1) == '_'
        ) {
            return "false";
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!(Character.isLetterOrDigit(ch) || ch == '_')) {
                return "false";
            }
        }

        return "true";
    }
}
