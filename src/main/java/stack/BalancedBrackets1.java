package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BalancedBrackets1 {

    // O(n) time | O(n) space
    public static boolean balancedBrackets(String str) {
        if (str == null || str.isEmpty()) return true;

        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char top = stack.pop();
                if (top != c) return false;
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
