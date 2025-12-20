package interview.asked;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySum {
    public static int longestSubarraySum(int[] arr, int k) {
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        int sum = 0, maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLength = i + 1;
            }

            if (sumIndexMap.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - sumIndexMap.get(sum - k));
            }

            if (!sumIndexMap.containsKey(sum)) {
                sumIndexMap.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 5};
        int k1 = 5;
        System.out.println("Length of longest subarray with sum " + k1 + " is " + longestSubarraySum(arr1, k1));

        int[] arr2 = {2, 3, 5, 1, 9};
        int k2 = 10;
        System.out.println("Length of longest subarray with sum " + k2 + " is " + longestSubarraySum(arr2, k2));

        int[] arr3 = {3, 4, 1, 3, 9};
        int k3 = 10;
        System.out.println("Length of longest subarray with sum " + k3 + " is " + longestSubarraySum(arr3, k3));
    }
}
