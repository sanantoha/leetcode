package dynamic;

public class BestTimeToBuyAndSellStock1 {

    // O(n) time | O(1) space
    public static int maxProfit(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int maxProfit = 0;
        int minVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - minVal;
            if (diff > maxProfit) {
                maxProfit = diff;
            }

            if (minVal > arr[i]) {
                minVal = arr[i];
            }
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
