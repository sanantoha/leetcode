package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberMnemonic {

    // O(n * 4 ^ n) time | O(n * 4 ^ n) space
    public static List<String> phoneNumberMnemonics(String phoneNumber) {
        List<String> result = new ArrayList<>();
        String[] letters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(0, letters, phoneNumber, "", result);
        return result;
    }

    private static void backtrack(int idx, String[] letters, String phoneNumber, String ans, List<String> result) {
        if (idx == phoneNumber.length()) {
            result.add(ans);
            return;
        }

        char c = phoneNumber.charAt(idx);
        int digit = Character.getNumericValue(c);
        String letter = letters[digit];
        for (int i = 0; i < letter.length(); i++) {
            backtrack(idx + 1, letters, phoneNumber, ans + letter.charAt(i), result);
        }
    }

    public static void main(String[] args) {
        String s = "1905";

        // [1w0j, 1w0k, 1w0l, 1x0j, 1x0k, 1x0l, 1y0j, 1y0k, 1y0l, 1z0j, 1z0k, 1z0l]
        System.out.println(phoneNumberMnemonics(s));
    }
}
