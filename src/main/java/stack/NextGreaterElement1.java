package stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElement1 {

    // O(n) time | O(n) space
    public static int[] nextGreaterElement(int[] array) {
        if (array == null || array.length == 0) return new int[] {};

        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[array.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < 2 * array.length; i++) {
            int currIdx = i % array.length;

            while (!stack.isEmpty() && array[stack.peek()] < array[currIdx]) {
                int top = stack.pop();
                res[top] = array[currIdx];
            }

            stack.push(currIdx);
        }
        return res;
    }

    // O(n) time | O(n) space
    public static int[] nextGreaterElement1(int[] array) {
        if (array == null || array.length == 0) return new int[] {};

        Deque<Integer> stack = new LinkedList<>();

        int[] res = new int[array.length];
        Arrays.fill(res, -1);

        for (int i = 2 * array.length - 1; i >= 0; i--) {
            int currIdx = i % array.length;

            while (!stack.isEmpty()) {
                if (stack.peek() <= array[currIdx]) {
                    stack.pop();
                } else {
                    res[currIdx] = stack.peek();
                    break;
                }
            }

            stack.push(array[currIdx]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[] {2, 5, -3, -4, 6, 7, 2};
        int[] actual = nextGreaterElement(input);
        System.out.println(Arrays.toString(actual)); // [5, 6, 6, 6, 7, -1, 5]

        actual = nextGreaterElement1(input);
        System.out.println(Arrays.toString(actual)); // [5, 6, 6, 6, 7, -1, 5]
    }
}
