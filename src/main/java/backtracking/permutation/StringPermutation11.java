package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation11 {

    // O(n ^ 2 * n!) time | O(n * n!) space
    public static List<String> permute(String src) {
        List<String> res = new ArrayList<>();
        backtrack(src, "", res);
        return res;
    }

    private static void backtrack(String src, String ans, List<String> res) {
        if (src.isEmpty()) {
            res.add(ans);
            return;
        }

        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            String rem = src.substring(0, i) + src.substring(i + 1);
            backtrack(rem, ans + c, res);
        }
    }


    public static void main(String[] args) {
        String str = "abc";

        System.out.println(permute(str));
    }
}
