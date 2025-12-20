package io.practice.dsa30days.challenges;

// Given an array nums with n objects colored red, white, or
//blue, sort them in-place so that objects of the same color are
//adjacent, with the colors in the order red, white, and blue.
// {2,0,1,1,1,0,2,2,0,0,1}

import java.util.Arrays;

public class SortTheColorBall {

    public void sortTheColorBall(String[] ball) {
        int left = 0;
        int right = ball.length - 1;
        int current = 0;
        while (current <= right) {
            if (ball[current].equalsIgnoreCase("red")) {
                // swap left to current
                swap(ball, left, current);
                left++;
                current++;
            } else if (ball[current].equalsIgnoreCase("blue")) {
                // swap current to right
                swap(ball, current, right);
                right--;
            } else {
                current++;
            }
        }
    }

    private void swap(String[] ball, int i, int j) {
        String temp = ball[i];
        ball[i] = ball[j];
        ball[j] = temp;
    }

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int current = 0;

        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left, current);
                left++;
                current++;
            } else if (nums[current] == 2) {
                swap(nums, current, right);
                right--;
            } else {
                current++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortTheColorBall obj = new SortTheColorBall();
        String[] ball = new String[] {"blue", "red", "red", "white", "white", "blue", "blue", "red", "white"};
        obj.sortTheColorBall(ball);
        System.out.println(Arrays.toString(ball));

        int[] color = new int[] {2,0,1,1,1,0,2,2,0,0,1};
        obj.sortColors(color);
        System.out.println(Arrays.toString(color));
    }
}
