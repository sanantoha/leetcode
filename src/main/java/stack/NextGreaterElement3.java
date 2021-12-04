package stack;

import java.util.Arrays;

public class NextGreaterElement3 {

    public static int[] nextGreaterElement(int[] array) {
        return null;
    }

    public static int[] nextGreaterElement1(int[] arr) {
        return null;
    }

    public static void main(String[] args) {
        int[] input = new int[] {2, 5, -3, -4, 6, 7, 2};
        int[] actual = nextGreaterElement(input);
        System.out.println(Arrays.toString(actual)); // [5, 6, 6, 6, 7, -1, 5]

        actual = nextGreaterElement1(input);
        System.out.println(Arrays.toString(actual)); // [5, 6, 6, 6, 7, -1, 5]
    }
}
