package interview.asked;

public class StockMaxProfit {
    //You are given an array prices where prices[i] is the price of stock on the i'th day.
    //You want to maximize your profit by choosing a single day to buy and choosing a different day in the future to sell.
    //Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    //Ex: [100, 120, 150, 190, 80, 180, 60]
    //

    public static void main(String[] args) {
        int[] price = new int[] {100, 120, 150, 190, 80, 180, 60};
        int min = Integer.MAX_VALUE;
        int todayProfit  = 0;
        int totalProfit = 0;
        for (int i = 0; i < price.length; i++) {
            min = Math.min(min, price[i]);
            todayProfit = price[i] - min;
            totalProfit = Math.max(todayProfit, totalProfit);
        }
        System.out.println(totalProfit);
    }
    /* Select employee name, if there is a preferred name type get preferred else get primary name

    employee_id	Name_type	Name
    1000		PRI			abc
    1001		PRI			def
    1001		PRF			ghi

    Expected outpout:
    Employee_id	Name
    1000		abc
    1001		ghi */
    // SELECT distinct(employee_id), Name from EMPLOYEE WHERE EMPLOYEE.Name_type='PRF' or EMPLOYEE.Name_type='PRI'
}
