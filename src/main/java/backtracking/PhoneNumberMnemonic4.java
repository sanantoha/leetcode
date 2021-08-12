package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberMnemonic4 {

    public static List<String> phoneNumberMnemonic(String phoneNumber) {
        List<String> res = new ArrayList<>();
        String[] letters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(phoneNumber, letters, "", 0, res);
        return res;
    }

    private static void backtrack(String phoneNumber, String[] letters, String ans, int idx, List<String> res) {
        if (phoneNumber.length() == ans.length()) {
            res.add(ans);
            return;
        }
        char c = phoneNumber.charAt(idx);
        int digit = Character.getNumericValue(c);
        String letter = letters[digit];
        for (int i = 0; i < letter.length(); i++) {
            // 1w0j
            backtrack(phoneNumber, letters, ans + letter.charAt(i), idx + 1, res);
        }
    }

    public static void main(String[] args) {
        String str = "1905";

        System.out.println(phoneNumberMnemonic(str));
    }
}
