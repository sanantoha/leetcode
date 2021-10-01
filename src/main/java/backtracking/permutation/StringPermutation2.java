package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation2 {

    // O(n * n!) time | O(n!) space
    public static List<String> permute(String src) {
        List<String> result = new ArrayList<>();
        backtracking(src, "", result);
        return result;
    }

    private static void backtracking(String src, String answer, List<String> result) {
        if (src.length() == 0) {
            result.add(answer);
            return;
        }

        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            String remaining = src.substring(0, i) + src.substring(i + 1);
            backtracking(remaining, answer + c, result);
        }
    }


    public static void main(String[] args) {
        System.out.println(permute("ABC"));

        System.out.println(permute("ABCD"));
    }
}
