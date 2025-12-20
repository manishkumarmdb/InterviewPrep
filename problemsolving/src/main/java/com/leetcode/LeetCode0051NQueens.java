package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0051NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        solveNQueens(n, 0, "", new ArrayList<String>(), result);
        return result;
    }

    private void solveNQueens(int n, int index, String s, ArrayList<String> strings, List<List<String>> result) {
        if (index == n) {

        }
    }
}
