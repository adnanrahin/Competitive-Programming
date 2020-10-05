package HackerRank.DynamicProgramming.CoinChange;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Long> coins = new ArrayList<>();
        coins.add((long) 2);
        coins.add((long) 3);
        coins.add((long) 3);
        coins.add((long) 6);

        System.out.println(getWays(10, coins));

    }

    public static long getWays(int n, List<Long> c) {
        long[] dp = new long[n + 1];

        dp[0] = 1;

        for (int i = 0; i < c.size(); i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= c.get(i))
                    dp[j] += dp[(int) (j - c.get(i))];
            }
        }
        return dp[n];
    }

}
