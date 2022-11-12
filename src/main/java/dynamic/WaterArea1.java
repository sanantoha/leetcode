package dynamic;

public class WaterArea1 {

    public static int waterArea(int[] heights) {
        return -1;
    }

    public static int waterArea1(int[] heights) {
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        System.out.println(waterArea(input) == 48);

        System.out.println(waterArea1(input) == 48);
    }
}
