package stack;

import java.util.Arrays;

/**
 * https://www.algoexpert.io/questions/Next%20Greater%20Element
 */
public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] array) {
        return null;
    }

    public static void main(String[] args) {
        int[] input = new int[] {2, 5, -3, -4, 6, 7, 2};
        int[] actual = nextGreaterElement(input);
        System.out.println(Arrays.toString(actual)); // [5, 6, 6, 6, 7, -1, 5]
    }
}
