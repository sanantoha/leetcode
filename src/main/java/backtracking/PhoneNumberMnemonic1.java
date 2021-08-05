package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberMnemonic1 {

    public static List<String> phoneNumberMnemonics(String phoneNumber) {
        List<String> result = new ArrayList<>();
        String[] letters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(phoneNumber, letters, "", 0, result);
        return result;
    }

    private static void backtrack(String phoneNumber, String[] letters, String ans, int idx, List<String> result) {
        if (idx == phoneNumber.length()) {
            result.add(ans);
            return;
        }
        char c = phoneNumber.charAt(idx);
        int digit = Character.getNumericValue(c);
        String letter = letters[digit];
        for (int i = 0; i < letter.length(); i++) {
            backtrack(phoneNumber, letters, ans + letter.charAt(i), idx + 1, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(phoneNumberMnemonics("1905"));
    }
}
