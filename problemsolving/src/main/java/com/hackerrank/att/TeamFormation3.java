package com.hackerrank.att;

import java.util.Arrays;
import java.util.List;

public class TeamFormation3 {

  /*
  * 1. Take each time point from every start and end.
  * 2. For each time t
  * 3. Count how many intervals contain t
  * 4. Track maximum overlap
  * 5. Return maxOverlap / 3
  * */
  private static int maxTeams(List<Integer> startTime, List<Integer> endTime) {

    int n = startTime.size();
    int maxOverlap = 0;
    for (int i = 0; i < n; i++) {
      int currentStartTime = startTime.get(i);
      int count = 0;
      for (int j = 0; j < n; j++) {
        if (startTime.get(j) <= currentStartTime && currentStartTime <= endTime.get(j)) {
          count++;
        }
      }
      maxOverlap = Math.max(maxOverlap, count);
    }

    return maxOverlap / 3;
  }

  public static void main(String[] args) {
    List<Integer> startTime = Arrays.asList(1,2,3,4);
    List<Integer> endTime = Arrays.asList(10,5,6,7);
    System.out.println(maxTeams(startTime, endTime));
  }
}
