package com.leetcode;

public class LeetCode0169MajorityElement {

  // Boyer-Moore Voting Algorithm
  // Finds majority element (appears > n/2 times) in O(1) space
  // Core idea: Majority element survives after all cancellations
  private static int majorityElement(int[] nums) {
    int current = nums[0];  // Candidate for majority element
    int vote = 1;           // Vote count for current candidate
    
    for (int i = 1; i < nums.length; i++) {
      if (vote == 0) {
        // No votes left, pick new candidate
        current = nums[i];
        vote = 1;
      } else if (current == nums[i]) {
        // Element matches candidate, increment vote
        vote++;
      } else {
        // Element differs, decrement vote (cancellation)
        vote--;
      }
    }
    return current;
  }

  public static void main(String[] args) {
    int[] nums = {2,2,1,1,1,2,2};
    System.out.println(majorityElement(nums));
  }
}
