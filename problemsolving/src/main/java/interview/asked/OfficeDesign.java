package interview.asked;

public class OfficeDesign {

    public static int getMaxColors(int[] prices, int money) {
        int start = 0, end = 0, currentSum = 0, maxColors = 0;

        while (end < prices.length) {
            currentSum += prices[end];

            while (currentSum > money) {
                currentSum -= prices[start];
                start++;
            }

            maxColors = Math.max(maxColors, end - start + 1);
            end++;
        }

        return maxColors;
    }

    public static void main(String[] args) {
        int[] price = {2,3,5,1,1,2,1};
        int money = 7;
        System.out.println(getMaxColors(price, money));
    }
}
