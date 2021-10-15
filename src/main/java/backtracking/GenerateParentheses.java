package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private static void backtracking(List<String> result, String answer, int open, int close, int maxInd) {
        if (answer.length() == maxInd * 2) {
            result.add(answer);
            return;
        }

        if (open < maxInd) backtracking(result, answer + '(', open + 1, close, maxInd);
        if (close < open) backtracking(result, answer + ')', open, close + 1, maxInd);
    }

    // O((4 ^ n)/sqrt(n)) time | O(n) space // found in leetcode https://leetcode.com/problems/generate-parentheses/solution/
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(result, "", 0,0, n);
        return result;
    }

    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));

        System.out.println(generateParenthesis(4));
    }
}
