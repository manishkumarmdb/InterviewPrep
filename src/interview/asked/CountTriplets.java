package interview.asked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    public long evenproduct(List<Integer> nums) {
        // Calculate the number of even numbers
        long evenCount = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                evenCount++;
            }
        }

        // Calculate the total number of triplets
        long n = nums.size();
        long totalTriplets = n * (n - 1) * (n - 2) / 6;

        // Calculate the number of triplets with all odd numbers
        long oddTriplets = (n - evenCount) * (n - evenCount - 1) * (n - evenCount - 2) / 6;

        // Subtract the number of triplets with all odd numbers
        // from the total number of triplets to get the number
        // of triplets with at least one even number
        long evenProductTriplets = totalTriplets - oddTriplets;

        // Return the result modulo (10^9 + 7)
        return (long) (evenProductTriplets % 1000000007);
    }

    public long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> leftMap = new HashMap<>();
        Map<Long, Long> rightMap = new HashMap<>();
        for (Long num : arr) {
            rightMap.put(num, rightMap.getOrDefault(num, 0L) + 1);
        }

        Long count = 0L;

        for (Long num : arr) {
            rightMap.put(num, rightMap.get(num) - 1);
            //find number of num/r before i
            Long lower = 0L;
            if (num % r == 0)
                lower = leftMap.getOrDefault(num / r, 0L);

            //find number of num*r after i
            Long upper = rightMap.getOrDefault(num * r, 0L);
            count += lower * upper;

            leftMap.put(num, leftMap.getOrDefault(num, 0L) + 1);
        }


        return count;

    }

    public int count_Triplets(List<Integer> A) {
        int max_val = 0;
        for (int i = 0; i < A.size(); i++)
            max_val = Math.max(max_val, A.get(i));
        int[] freq = new int[max_val + 1];
        for (int i = 0; i < A.size(); i++)
            freq[A.get(i)]++;

        int count = 0;

        count += freq[0] * (freq[0] - 1) * (freq[0] - 2) / 6;

        for (int i = 1; i <= max_val; i++)
            count += freq[0] * freq[i] * (freq[i] - 1) / 2;


        for (int i = 1; 2 * i <= max_val; i++)
            count += freq[i] * (freq[i] - 1) / 2 * freq[2 * i];

        for (int i = 1; i <= max_val; i++) {
            for (int j = i + 1; i + j <= max_val; j++)
                count += freq[i] * freq[j] * freq[i + j];
        }

        return count;
    }

    public static void main(String[] args) {
        CountTriplets obj = new CountTriplets();
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(4);
        nums.add(8);
        nums.add(2);
        System.out.println(obj.evenproduct(nums));
    }
}
