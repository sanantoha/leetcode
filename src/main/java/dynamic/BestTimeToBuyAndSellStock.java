package dynamic;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int maxProfit = 0;
        int minV = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - minV;
            if (maxProfit < diff) maxProfit = diff;

            if (minV > arr[i]) minV = arr[i];
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
