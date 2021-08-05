package top.interview.question.bloomberg;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringOfAllCharacters {

    public static String getShortestUniqueSubstring(char[] arr, String str) {
        if (arr == null || arr.length == 0) return "";
        if (str == null || str.isEmpty()) return "";

        Map<Character, Integer> alpha = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int cnt = alpha.getOrDefault(arr[i], 0);
            alpha.put(arr[i], cnt + 1);
        }

        int unique = alpha.size();

        int i;
        for (i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

//            alpha[c - 'a']--;
//
//            if (i - arr.length >= 0) alpha[str.charAt(i - arr.length) - 'a']++;
//
//            if (i - arr.length >= 0 && check(alpha)) {
//                StringBuilder res = new StringBuilder();
//                System.out.println(i - arr.length + 1);
//                System.out.println(i);
//                for (int j = i - arr.length + 1; j <= i; j++) {
//                    res.append(str.charAt(j));
//                }
//                return res.toString();
//            }
        }
        return "";
    }

    private static boolean check(char[] alpha) {
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[] arr = {'x', 'y', 'z', 'k'};
        String str = "xyyzyzyxkyxdd";

        System.out.println(getShortestUniqueSubstring(arr, str));
    }
}
