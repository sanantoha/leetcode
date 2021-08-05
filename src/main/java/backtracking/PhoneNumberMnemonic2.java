package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberMnemonic2 {

    public static List<String> phoneNumberMnemonic(String str) {
        List<String> result = new ArrayList<>();
        String[] letters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(str, "", letters, 0, result);
        return result;
    }

    private static void backtrack(String str, String ans, String[] letters, int start, List<String> result) {
        if (start == str.length()) {
            result.add(ans);
            return;
        }
        char c = str.charAt(start);
        int digit = Character.getNumericValue(c);
        String letter = letters[digit];

        for (int i = 0; i < letter.length(); i++) {
            backtrack(str, ans + letter.charAt(i), letters, start + 1, result);
        }
    }

    public static void main(String[] args) {
        String str = "1902";
        System.out.println(phoneNumberMnemonic(str));
    }
}
