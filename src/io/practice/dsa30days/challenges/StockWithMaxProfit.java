package io.practice.dsa30days.challenges;

public class StockWithMaxProfit {

    public int maxProfit(int[] price) {
        int totalProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < price.length; i++) {
            min = Math.min(min, price[i]);
            int todayProfit = price[i] - min;
            totalProfit = Math.max(totalProfit, todayProfit);
        }

        return totalProfit;
    }
}
