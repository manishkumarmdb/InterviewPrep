package interview.asked;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTwoMissingNumbersInAnArray {

  private static int[] missingNumbers(int[] nums) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    Set<Integer> set = new HashSet<>();

    for (int num : nums) {
      min = Math.min(min, num);
      max = Math.max(max, num);
      set.add(num);
    }

    int[] result = new int[2];
    int j = 0;

    for (int i = min; i <= max && j < 2; i++) {
      if (!set.contains(i)) {
        result[j++] = i;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] number = {3, 2, 7, 1, 4, 8};
    System.out.println(Arrays.toString(missingNumbers(number)));
  }
}
