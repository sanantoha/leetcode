package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation3 {

    // O(n * n!) time | O(n!) space
    public static List<String> permute(String src) {
        List<String> result = new ArrayList<>();
        backtrack(src, "", result);
        return result;
    }

    private static void backtrack(String src, String ans, List<String> result) {
        if (src.length() == 0) {
            result.add(ans);
            return;
        }

        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            String remaining = src.substring(0, i) + src.substring(i + 1);
            backtrack(remaining, ans + c, result);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(permute(s));
    }
}
