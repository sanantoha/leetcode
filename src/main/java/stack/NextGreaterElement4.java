package stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElement4 {

    // O(n) time | O(n) space
    public static int[] nextGreaterElement(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};

        int[] nextGreater = new int[arr.length];
        Arrays.fill(nextGreater, -1);
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < 2 * arr.length; i++) {
            int currIdx = i % arr.length;

            while (!stack.isEmpty() && arr[stack.peek()] < arr[currIdx]) {
                int top = stack.pop();
                nextGreater[top] = arr[currIdx];
            }

            stack.push(currIdx);
        }

        return nextGreater;
    }

    // O(n) time | O(n) space
    public static int[] nextGreaterElement1(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};

        int[] nextGrater = new int[arr.length];
        Arrays.fill(nextGrater, -1);
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 2 * arr.length - 1; i >= 0; i--) {
            int currIdx = i % arr.length;

            while (!stack.isEmpty()) {
                if (stack.peek() <= arr[currIdx]) {
                    stack.pop();
                } else {
                    nextGrater[currIdx] = stack.peek();
                    break;
                }
            }

            stack.push(arr[currIdx]);
        }
        return nextGrater;
    }

    public static void main(String[] args) {
        int[] input = new int[] {2, 5, -3, -4, 6, 7, 2};
        int[] actual = nextGreaterElement(input);
        System.out.println(Arrays.toString(actual)); // [5, 6, 6, 6, 7, -1, 5]

        actual = nextGreaterElement1(input);
        System.out.println(Arrays.toString(actual)); // [5, 6, 6, 6, 7, -1, 5]
    }
}
