package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses7 {

    // O((4 ^ n) / sqrt(n)) time | O((4 ^ n) / sqrt(n)) space
    public static List<String> generateParenthesis(int cnt) {
        List<String> res = new ArrayList<>();
        backtrack(cnt, 0, 0, "", res);
        return res;
    }

    private static void backtrack(int cnt, int open, int close, String ans, List<String> res) {
        if (2 * cnt == open + close) {
            res.add(ans);
            return;
        }

        if (open < cnt) backtrack(cnt, open + 1, close, ans + "(", res);
        if (close < open) backtrack(cnt, open, close + 1, ans + ")", res);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));

        System.out.println(generateParenthesis(2));
    }
}
