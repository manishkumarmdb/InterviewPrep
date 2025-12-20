package interview.asked;

/*
* https://leetcode.com/discuss/interview-question/1874750/minimize-array-cost
*
* */
public class MinimizeArrayCost {

    public long getCost(int x, int y) {
        return (x - y) * (x - y);
    }

    public long minimumCost(int[] arr) {
        long maxCost = -1;
        int maxInd = -1;
        long totalCost = 0;
        for (int i = 1; i < arr.length; i++) {
            long cost = (arr[i] - arr[i - 1]) * (arr[i] - arr[i - 1]);
            totalCost += cost;
            if (cost > maxCost) {
                maxCost = cost;
                maxInd = i;
            }
        }
        // subtract square of maxInd value from totalCost
        totalCost -= getCost(arr[maxInd], arr[maxInd - 1]);
        int mid = (arr[maxInd] + arr[maxInd - 1]) / 2;
        return totalCost + getCost(arr[maxInd], mid) + getCost(arr[maxInd - 1], mid);
    }
}
