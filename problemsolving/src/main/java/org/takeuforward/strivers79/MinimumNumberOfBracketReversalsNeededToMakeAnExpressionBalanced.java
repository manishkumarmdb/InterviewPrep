package org.takeuforward.strivers79;

public class MinimumNumberOfBracketReversalsNeededToMakeAnExpressionBalanced {

  // Function to calculate the minimum number of reversals to balance the expression
  private static int minReversalsToBalance(String expression) {
    if (expression.length() % 2 != 0) {
      return -1;
    }
    int openBrackets = 0;
    int closeBrackets = 0;
    for (char ch : expression.toCharArray()) {
      if (ch == '(') {
        openBrackets++;
      } else {
        if (openBrackets > 0) {
          openBrackets--;
        } else {
          closeBrackets++;
        }
      }
    }
    return (openBrackets + 1) / 2 + (closeBrackets + 1) / 2;
  }

  public static void main(String[] args) {
    // Input expression
    String expression = "(()((()(())((";

    // Get result from function
    int result = minReversalsToBalance(expression);

    // Print the result
    System.out.println("Minimum reversals required: " + result);
  }

}
