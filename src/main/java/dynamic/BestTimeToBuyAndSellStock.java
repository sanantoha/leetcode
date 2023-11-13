package dynamic;

public class BestTimeToBuyAndSellStock {

    // O(n) time | O(1) space
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int maxProfit = 0;
        int minVal = prices[0];

        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minVal);
            minVal = Math.min(minVal, price);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.println(maxProfit(prices) == 5);

        int[] prices1 = {7,6,4,3,1};

        System.out.println(maxProfit(prices1) == 0);
    }
}
