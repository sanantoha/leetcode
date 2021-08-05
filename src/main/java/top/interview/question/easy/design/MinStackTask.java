package top.interview.question.easy.design;


import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {

    private static class Entry {
        private final int val;

        private final int min;

        public Entry(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private final Deque<Entry> stack = new ArrayDeque<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {
        int min = Integer.MAX_VALUE;
        if (!stack.isEmpty()) {
            min = stack.getFirst().min;
        }
        stack.push(new Entry(val, Math.min(min, val)));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.getFirst().val;
    }

    public int getMin() {
        return stack.getFirst().min;
    }
}

public class MinStackTask {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
