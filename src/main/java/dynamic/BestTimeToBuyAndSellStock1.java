package dynamic;

public class BestTimeToBuyAndSellStock1 {

    public static int maxProfit(int[] prices) {
        return -1;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.println(maxProfit(prices) == 5);

        int[] prices1 = {7,6,4,3,1};

        System.out.println(maxProfit(prices1) == 0);
    }
}
