package com.mettl.coforge;

public class ReduceStringToOneChar {

  private static String reduceString(String input1, int input2) {

    String modifiedString = input1;
    while(input2-- > 1) {
      System.out.println(input2);
      modifiedString += input1;
    }
    input1 = modifiedString;
    System.out.println(input1);

    while (input1.length() > 1) {

      // Step 1: Remove alternate chars from beginning
      input1 = removeAlternateFromBeginning(input1);
      if (input1.length() == 1) return input1;

      // Step 2: Remove alternate chars from ending
      input1 = removeAlternateFromEnd(input1);
      if (input1.length() == 1) return input1;
    }
    return input1;
  }

  private static String removeAlternateFromBeginning(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < str.length(); i += 2) {
      sb.append(str.charAt(i));
    }
    return sb.toString();
  }

  private static String removeAlternateFromEnd(String str) {
    StringBuilder sb = new StringBuilder();
    boolean remove = true;

    for (int i = str.length() - 1; i >= 0; i--) {
      if (!remove) {
        sb.append(str.charAt(i));
      }
      remove = !remove;
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(reduceString("abcd", 3));
  }
}
