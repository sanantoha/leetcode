package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

    public static List<String> permute(String src) {
        List<String> result = new ArrayList<>();
        backtracking(result, "", src);
        return result;
    }

    private static void backtracking(List<String> result, String answer, String src) {
        if (src.length() == 0) {
            result.add(answer);
            return;
        }

        for (int i = 0; i < src.length(); i++) {
            String remaining = src.substring(0, i) + src.substring(i + 1);
            backtracking(result, answer + src.charAt(i), remaining);
        }
    }

    public static void main(String[] args) {
        String s = "abc";

        System.out.println(permute(s));
    }
}
