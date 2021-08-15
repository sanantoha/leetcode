package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation5 {

    public static List<String> permute(String str) {
        List<String> res = new ArrayList<>();
        backtrack(str,"", res);
        return res;
    }

    private static void backtrack(String str, String ans, List<String> res) {
        if (str.length() == 0) {
            res.add(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String rem = str.substring(0, i) + str.substring(i + 1);
            backtrack(rem,ans + c, res);
        }
    }

    public static void main(String[] args) {
        String str = "abc";

        System.out.println(permute(str));
    }
}
