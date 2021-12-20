package dynamic;

public class MinNumberOfCoinsForChange4 {

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 10};
        int actual = minNumberOfCoinsForChange(7, input);
        System.out.println(actual);
        System.out.println(actual == 3);
    }
}
