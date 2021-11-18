package dynamic;

public class BestTimeToBuyAndSellStock2 {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices == null || prices.length == 0) return maxProfit;

        int minVal = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minVal;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            minVal = Math.min(minVal, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.println(maxProfit(prices));

        int[] prices1 = {7,6,4,3,1};

        System.out.println(maxProfit(prices1));
    }
}
