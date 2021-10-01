package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation1 {

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
            String rem = src.substring(0, i) + src.substring(i + 1);
            backtracking(rem, answer + src.charAt(i), result);
        }

    }

    public static void main(String[] args) {
        String src = "abc";

        System.out.println(permute(src));
    }
}
