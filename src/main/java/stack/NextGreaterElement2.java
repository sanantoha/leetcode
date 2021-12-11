package stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElement2 {

    // O(n) time | O(n) space
    public static int[] nextGreaterElement(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};

        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[arr.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < 2 * arr.length; i++) {
            int currIdx = i % arr.length;

            while (!stack.isEmpty() && arr[stack.peek()] < arr[currIdx]) {
                int top = stack.pop();
                res[top] = arr[currIdx];
            }

            stack.push(currIdx);
        }

        return res;
    }

    // O(n) time | O(n) space
    public static int[] nextGreaterElement1(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};

        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[arr.length];
        Arrays.fill(res, -1);

        for (int i = 2 * arr.length - 1; i >= 0; i--) {
            int currIdx = i % arr.length;
            int currVal = arr[currIdx];
            while (!stack.isEmpty()) {
                if (currVal >= stack.peek()) {
                    stack.pop();
                } else {
                    res[currIdx] = stack.peek();
                    break;
                }
            }

            stack.push(arr[currIdx]);
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
