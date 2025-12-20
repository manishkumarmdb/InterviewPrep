package interview.asked;

public class MinimumCoins {
    private int minimumCoins(int[] coins, int target) {
        int[] memo = new int[target + 1];
        memo[0] = 0;
        for (int i = 1; i <= target; i++) {
            for (int coin : coins) {
                int subproblem = i - coin;
                if (subproblem < 0)
                    continue;
                memo[i] = min_ignore_none(memo[i], memo[subproblem] + 1);
            }
        }
        return memo[target];
    }

    private int min_ignore_none(int a, int b) {
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        MinimumCoins minimumCoins = new MinimumCoins();
        int[] coins = {1, 4, 5};
        int target = 13;
        System.out.println(minimumCoins.minimumCoins(coins, target));
    }
}
