package com.leetcode;

public class LeetCode0050PowXN {

    public double myPow(double x, int n) {
        double result = 0;
        result = Math.pow(x, n);
        return Math.round(result);
    }
}
