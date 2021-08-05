package top.interview.question.easy.dynamic;

class Solution1 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - min;
            if (diff > maxProfit) {
                maxProfit = diff;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return maxProfit;
    }
}

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution1 s = new Solution1();

        int[] prices = {7,1,5,3,6,4};

        System.out.println(s.maxProfit(prices));

        int[] prices1 = {7,6,4,3,1};

        System.out.println(s.maxProfit(prices1));
    }
}
