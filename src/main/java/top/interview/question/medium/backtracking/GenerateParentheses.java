package top.interview.question.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(result, "", 0, 0, n);
        return result;
    }

    public void backtracking(List<String> result, String answer, int open, int close, int maxInd) {
        if (answer.length() == maxInd * 2) {
            result.add(answer);
            return;
        }

        if (open < maxInd) backtracking(result, answer + '(', open + 1, close, maxInd);
        if (close < open) backtracking(result, answer + ')', open, close + 1, maxInd);
    }
}

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution1 s = new Solution1();

        System.out.println(s.generateParenthesis(3));

        System.out.println(s.generateParenthesis(1));
    }
}
