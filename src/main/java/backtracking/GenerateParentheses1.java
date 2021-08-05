package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses1 {

    public static List<String> generateParenthesis(int cnt) {
        List<String> result = new ArrayList<>();
        backtrack(0, 0, cnt, "", result);
        return result;
    }

    private static void backtrack(int open, int close, int cnt, String ans, List<String> result) {
        if (cnt * 2 == ans.length()) {
            result.add(ans);
            return;
        }

        if (open < cnt) backtrack(open + 1, close, cnt, ans + '(', result);
        if (close < open) backtrack(open, close + 1, cnt, ans + ')', result);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));

        System.out.println(generateParenthesis(2));
    }
}
