package com.leetcode;

public class LeetCode0875KokoEatingBananas {

  // Binary Search approach to find minimum eating speed
  // Time: O(n log m) where n = piles.length, m = max pile size
  // Space: O(1)
  // Find minimum eating speed (bananas per hour) such that Koko can eat all piles within h hours
  // Example: piles=[30,11,23,4,20], h=6 -> minimum speed is 23 bananas/hour
  private static int minEatingSpeed(int[] piles, int h) {
    // Search space: speed ranges from 1 to max pile size
    long left = 1;                    // Minimum speed is 1 banana per hour
    long right = 0;                   // Maximum speed is the largest pile
    
    // Find the maximum pile (upper bound for binary search)
    for (int pile : piles)
      right = Math.max(right, pile);
    
    // Binary search for minimum speed that satisfies time constraint
    while (left < right) {
      long mid = left + (right - left) / 2;  // Current speed to test (prevents overflow)
      
      // Check if Koko can eat all piles at speed 'mid' within h hours
      if (canEatAll(piles, h, mid))
        right = mid;  // Speed is feasible, try slower speed
      else
        left = mid + 1;  // Speed is too slow, try faster speed
    }
    
    return (int) left;  // left = right = minimum speed found
  }

  // Helper method to check if all piles can be eaten at speed k within h hours
  // For each pile, calculate hours needed: ceil(pile / k) = (pile + k - 1) / k
  private static boolean canEatAll(int[] piles, int h, long k) {
    long minTime = 0;
    
    for (int pile : piles) {
      // Calculate hours needed for this pile (ceiling division)
      minTime += pile / k;           // Integer division: quotient
      if (pile % k > 0)              // If there's remainder, need one more hour
        minTime++;
      
      // Early termination if time exceeds limit
      if (minTime > h)
        return false;
    }
    
    return true;  // All piles eaten within time limit
  }

  public static void main(String[] args) {
    int[] piles = {30, 11, 23, 4, 20};
    int h = 6;
    System.out.println(minEatingSpeed(piles, h));
  }
}
