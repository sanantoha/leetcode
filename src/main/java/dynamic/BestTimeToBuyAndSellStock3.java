package dynamic;

public class BestTimeToBuyAndSellStock3 {

    // O(n) time | O(1) space
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return -1;

        int maxProfit = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - min;
            maxProfit = Math.max(maxProfit, currProfit);
            min = Math.min(min, prices[i]);
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
