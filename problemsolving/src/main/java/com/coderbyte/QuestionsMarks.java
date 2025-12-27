package com.coderbyte;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuestionsMarks {

  private static String questionsMarks(String str) {
    // code goes here
    int lastDigitSeen = -1; // stores last digit seen
    int questionCount = 0;
    boolean foundValidPair = false;

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (Character.isDigit(ch)) {
        int currentDigit = ch - '0';

        if (lastDigitSeen != -1) {
          if (lastDigitSeen + currentDigit == 10) {
            if (questionCount != 3) {
              return "false";
            }
            foundValidPair = true;
          }
        }

        lastDigitSeen = currentDigit;
        questionCount = 0;
      } else if (ch == '?' && lastDigitSeen != -1) {
        questionCount++;
      }
    }

    return foundValidPair ? "true" : "false";
  }

  public static void main(String[] args) {
    System.out.println(questionsMarks("arrb6???4xxbl5???eee5")); // true
    System.out.println(questionsMarks("aa6???5")); // false
    System.out.println(questionsMarks("acc?7??sss?3rr1??????5")); // true
  }
}
