package com.leetcode;

public class LeetCode0875KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        long left = 1, right = 0;
        for (int pile : piles)
            right = Math.max(right, pile);
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canEatAll(piles, h, mid))
                right = mid;
            else
                left = mid + 1;
        }
        return (int) left;
    }

    private boolean canEatAll(int[] piles, int h, long k) {
        long minTime = 0;
        for (int pile : piles) {
            minTime += pile / k;
            if (pile % k > 0)
                minTime++;
            if (minTime > h)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0875KokoEatingBananas obj = new LeetCode0875KokoEatingBananas();
        int[] piles = {30,11,23,4,20};
        int h = 6;
        System.out.println(obj.minEatingSpeed(piles, h));
//        Arrays.stream(piles)
//                .mapToDouble(e -> (e + 23 - 1))
//                .forEach(System.out::println);
    }
}
