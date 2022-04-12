package stack;

import java.util.*;

public class BalancedBrackets2 {

    // O(n) time | O(n) space
    public static boolean balancedBrackets(String str) {
        if (str == null || str.length() == 0) return true;

        Map<Character, Character> openToClose = Map.of('(', ')', '{', '}', '[', ']');
        Set<Character> closes = new HashSet<>(openToClose.values());

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (openToClose.containsKey(c)) {
                stack.push(openToClose.get(c));
            } else if (closes.contains(c)) {
                if (stack.isEmpty()) return false;
                if (stack.pop() != c) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "([])(){}(())()()";

        System.out.println(balancedBrackets(input));

        System.out.println(balancedBrackets("}{"));
    }
}
