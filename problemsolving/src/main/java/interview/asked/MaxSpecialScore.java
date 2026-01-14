package interview.asked;

public class MaxSpecialScore {

  /*
  * Problem:
  * Checks whether the given string can be rearranged into two non-empty palindromic substrings
  * Returns the maximum possible score
  * Returns -1 if it is impossible
  *
  * Approach:
  * We count character frequencies to ensure no more than two odd counts,
  * which guarantees two palindromes are possible,
  * then split the length evenly to maximize the score.
  * */
  private static int maxSpecialScore(String str, int length) {
    /*
    * At least 2 characters are required to form two non-empty substrings
    * If the string length is less than 2 → immediately invalid
    * */
    if (length < 2) return -1;

    /*
    * Uses a fixed-size array for lowercase letters (a to z)
    * Counts how many times each character appears
    * Order does not matter because rearrangement is allowed
    * */
    int[] freq = new int[26];
    for (char c : str.toCharArray()) {
      freq[c - 'a']++;
    }

    /*
    * A palindrome allows at most one odd-frequency character
    * Since we need two palindromes, total odd characters allowed is 2
    * Bitwise check (f & 1) efficiently checks odd/even
    * */
    int oddCount = 0;
    for (int i : freq) {
      if ((i & 1) == 1) {
        oddCount++;
      }
    }

    /*
    * If more than two odd-frequency characters exist:
    * Cannot distribute them across two palindromes
    * Therefore, forming a special string is impossible
    * */
    if (oddCount > 2) return -1;

    /*
    * The product A × B is maximized when lengths are as equal as possible
    * This is a standard mathematical property
    * Works for both even and odd lengths
    * */
    int a = length / 2;
    int b = length - a;
    return a * b;
  }

  public static void main(String[] args) {
    String[] S = {"abazzyzz", "abc", "aa"};
    for (String str : S) {
      System.out.println(maxSpecialScore(str, str.length()));
    }
  }
}
