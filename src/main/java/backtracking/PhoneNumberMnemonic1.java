package backtracking;

import java.util.List;

public class PhoneNumberMnemonic1 {

    public static List<String> phoneNumberMnemonics(String str) {
        String[] letters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return null;
    }

    public static void main(String[] args) {
        String str = "1905";

        // [1w0j, 1w0k, 1w0l, 1x0j, 1x0k, 1x0l, 1y0j, 1y0k, 1y0l, 1z0j, 1z0k, 1z0l]
        System.out.println(phoneNumberMnemonics(str));
    }
}
