package dynamic;

public class BestTimeToBuyAndSellStock4 {

    // O(n) time | O(1) space
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int maxProfit = 0;
        int minVal = Integer.MAX_VALUE;

        for (int price : prices) {
            int diff = price - minVal;
            if (diff > maxProfit) {
                maxProfit = diff;
            }
            minVal = Math.min(price, minVal);
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
