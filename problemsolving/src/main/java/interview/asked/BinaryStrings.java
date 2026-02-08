package interview.asked;

import java.util.Arrays;

/*
 * Write a program to generate and print all binary strings of length n.
 * or
 * Given an integer n, print all possible combinations of 0 and 1 of length n.
 * */
public class BinaryStrings {

  private static void generateAllBinaryString(int n, int[] A, int index) {
    if (index == n) {
      System.out.println(Arrays.toString(A));
      return;
    }
    A[index] = 0;
    generateAllBinaryString(n, A, index + 1);

    A[index] = 1;
    generateAllBinaryString(n, A, index + 1);
  }

  public static void main(String[] args) {
    int n = 3;
    int[] A = new int[n];
    generateAllBinaryString(n, A, 0);
  }
}
