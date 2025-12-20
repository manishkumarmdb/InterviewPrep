package io.practice.dsa30days.challenges;

public class ContainerContainsTheMostWater {

    public int maximumAmountOfWaterInContainer(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        while (left < right) {
            int currentWater = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(maxWater, currentWater);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxWater;
    }
}
