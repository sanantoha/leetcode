package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BalancedBrackets1 {

    // O(n) time | O(1) space
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
            } else if (map.containsValue(c)) {
                if (stack.isEmpty()) return false;

                if (c != stack.pop()) return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "([])(){}(())()()";

        System.out.println(balancedBrackets(input));

        System.out.println(balancedBrackets("}{"));
    }
}
