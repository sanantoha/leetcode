package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberMnemonic5 {

    public static List<String> phoneNumberMnemonics(String phoneNumber) {
        List<String> res = new ArrayList<>();
        String[] letters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(phoneNumber, letters,"", 0, res);
        return res;
    }

    private static void backtrack(String phoneNumber, String[] letters, String answer, int idx, List<String> res) {
        if (idx == phoneNumber.length()) {
            res.add(answer);
            return;
        }

        char c = phoneNumber.charAt(idx);
        int digit = Character.getNumericValue(c);
        String letter = letters[digit];
        for (int i = 0; i < letter.length(); i++) {
            backtrack(phoneNumber, letters, answer + letter.charAt(i), idx + 1, res);
        }
    }

    public static void main(String[] args) {
        String str = "1905";

        System.out.println(phoneNumberMnemonics(str));
    }
}
