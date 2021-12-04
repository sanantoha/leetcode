package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberMnemonic9 {

    // O(n * 4 ^ n) time | O(n * 4 ^ n) space
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

        char c = str.charAt(idx);
        int digit = Character.getNumericValue(c);
        String letter = letters[digit];
        for (int i = 0; i < letter.length(); i++) {
            backtrack(str, letters, idx + 1, ans + letter.charAt(i), res);
        }
    }

    public static void main(String[] args) {
        String str = "1905";

        System.out.println(phoneNumberMnemonics(str));
    }
}
