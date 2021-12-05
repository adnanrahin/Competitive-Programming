package LeetCode.Array.BestTimeToBuyAndSellStock;

public class Main {

    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0, buy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) buy = prices[i];
            maxProfit = Math.max(maxProfit, prices[i] - buy);
        }

        return maxProfit;
    }

}
