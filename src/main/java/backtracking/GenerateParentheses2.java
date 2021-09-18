package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses2 {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, "", result);
        return result;
    }

    private static void backtrack(int n, int open, int close, String ans, List<String> result) {
        if (open + close == n * 2) {
            result.add(ans);
            return;
        }

        if (open < n) backtrack(n, open + 1, close, ans + '(', result);
        if (close < open) backtrack(n, open, close + 1, ans + ')', result);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));

        System.out.println(generateParenthesis(2));
    }
}
