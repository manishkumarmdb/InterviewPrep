package com.leetcode;

import java.util.Arrays;

public class LeetCode0238ProductOfArrayExceptSelf {

  // Approach 1: Prefix-Suffix Array approach
  // Time: O(n), Space: O(n) for pre and suf arrays
  // For each index i: result = (product of all left elements) * (product of all right elements)
  // Example: [1,2,3,4] -> [24,12,8,6]
  private static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] prefix = new int[n];   // prefix[i] = product of all elements before index i
    int[] suffix = new int[n];   // suffix[i] = product of all elements after index i

    // Initialize boundaries (no element before 0, no element after n-1)
    prefix[0] = 1;
    suffix[n - 1] = 1;

    // Build prefix and suffix arrays simultaneously
    int i = 1;
    while (i < n) {
      // prefix[i] = prefix[i-1] * nums[i-1]: accumulate product of left elements
      prefix[i] = prefix[i - 1] * nums[i - 1];

      // suffix[n-i-1] = suffix[n-i] * nums[n-i]: accumulate product of right elements
      suffix[n - i - 1] = suffix[n - i] * nums[n - i];
      i++;
    }

    // Calculate result: for each index, multiply left product and right product
    i = 0;
    while (i < n) {
      nums[i] = prefix[i] * suffix[i];
      i++;
    }

    return nums;
  }

  // Approach 2: Space-Optimized (Single pass from right, result array as output)
  // Time: O(n), Space: O(1) excluding result array
  // Build prefix products in result array, then multiply with suffix products on second pass
  // Example: [1,2,3,4] -> [24,12,8,6]
  private static int[] productExceptSelf_II(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];

    // Step 1: Build prefix products in result array
    // result[i] = product of all elements before index i
    result[0] = 1;
    for (int i = 1; i < n; i++) {
      result[i] = result[i - 1] * nums[i - 1];
    }
    System.out.println(Arrays.toString(result));

    // Step 2: Traverse from right, multiply with suffix products
    // suffix_product tracks running product of all elements after current index
    int suffix_product = 1;  // Product of all elements after current position
    for (int i = n - 1; i >= 0; i--) {
      // Multiply existing prefix product with suffix product
      result[i] *= suffix_product;

      // Update suffix product for next iteration (moving left)
      suffix_product *= nums[i];
    }
    System.out.println(Arrays.toString(result));

    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    System.out.println("Input: " + Arrays.toString(nums));
    System.out.println("Output: " + Arrays.toString(productExceptSelf(nums)));
    System.out.println("Output: " + Arrays.toString(productExceptSelf_II(new int[]{1, 2, 3, 4})));
  }
}
