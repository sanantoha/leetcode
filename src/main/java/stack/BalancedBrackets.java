package stack;

import java.util.*;

public class BalancedBrackets {

    // O(n) time | O(n) space
    public static boolean balancedBrackets(String str) {
        if (str == null || str.isEmpty()) return true;

        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> bracketsMapping = new HashMap<>();
        bracketsMapping.put('(', ')');
        bracketsMapping.put('{', '}');
        bracketsMapping.put('[', ']');
        Set<Character> closetBrackets = new HashSet<>(bracketsMapping.values());

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (bracketsMapping.keySet().contains(c)) {
                stack.push(c);
            } else if (closetBrackets.contains(c)) {
                if (stack.isEmpty()) return false;
                char openBracket = stack.pop();
                if (c != bracketsMapping.get(openBracket)) return false;
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
