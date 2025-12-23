package com.coderbyte;

public class FindIntersection {

  public static void main(String[] args) {
    String[] input = {
        "1, 3, 4, 7, 13",
        "1, 2, 4, 13, 15"
    };
    System.out.println(findIntersection(input)); // Output: 1,4,13
  }

  private static String findIntersection(String[] strArr) {
    String[] first = strArr[0].split(",\\s*");
    String[] second = strArr[1].split(",\\s*");
    StringBuilder sb = new StringBuilder();
    int i = 0, j = 0;
    while (i < first.length && j < second.length) {
      int x = Integer.parseInt(first[i]);
      int y = Integer.parseInt(second[j]);
      if (x == y) {
        if (sb.length() > 0) {
          sb.append(",");
        }
        sb.append(x);
        i++;
        j++;
      } else if (x < y) {
        i++;
      } else {
        j++;
      }
    }

    return sb.toString();
  }
}
