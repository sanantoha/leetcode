package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses3 {

    public static List<String> generateParenthesis(int cnt) {
        List<String> res = new ArrayList<>();
        backtrack(0, 0, cnt, "", res);
        return res;
    }

    private static void backtrack(int open, int close, int cnt, String ans, List<String> res) {
        if ((open + close) == cnt * 2) {
            res.add(ans);
            return;
        }

        if (open < cnt) backtrack(open + 1, close, cnt, ans + '(', res);
        if (close < open) backtrack(open, close + 1, cnt, ans + ')', res);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));

        System.out.println(generateParenthesis(2));
    }
}
