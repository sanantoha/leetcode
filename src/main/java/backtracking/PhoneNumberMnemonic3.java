package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberMnemonic3 {

    // O(4 ^ n * n) time | O(4 ^ n * n) space
    public static List<String> phoneNumberMnemonics(String str) {
        List<String> res = new ArrayList<>();
        String[] letters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(str, letters, 0, "", res);
        return res;
    }

    private static void backtrack(String str, String[] letters, int idx, String ans, List<String> res) {
        if (idx == str.length()) {
            res.add(ans);
            return;
        }

        char dc = str.charAt(idx);
        int d = Character.getNumericValue(dc);
        String ls = letters[d];
        for (int i = 0; i < ls.length(); i++) {
            backtrack(str, letters, idx + 1, ans + ls.charAt(i), res);
        }
    }

    public static void main(String[] args) {
        String str = "1905";

        System.out.println(phoneNumberMnemonics(str));
    }
}
