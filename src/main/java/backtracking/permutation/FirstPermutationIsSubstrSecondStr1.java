package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

public class FirstPermutationIsSubstrSecondStr1 {

    private static List<String> permute(String src) {
        List<String> result = new ArrayList<>();
        backtracking(src, "", result);
        return result;
    }

    private static void backtracking(String src, String answer, List<String> result) {
        if (src.length() == 0) {
            result.add(answer);
            return;
        }

        for (int i = 0; i < src.length(); i++) {
            String rem = src.substring(0, i) + src.substring(i + 1);
            backtracking(rem, answer + src.charAt(i), result);
        }
    }

    public static boolean findPermutation(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        for (String permute : permute(s1)) {
            if (s2.contains(permute)) return true;
        }
        return false;
    }

    private static boolean allZeros(int[] alpha) {
        for (int v : alpha) {
            if (v != 0) return false;
        }
        return true;
    }

    public static boolean findPermutation1(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] alpha = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            alpha[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            alpha[s2.charAt(i) - 'a']--;

            if (i - s1.length() >= 0) alpha[s2.charAt(i - s1.length()) - 'a']++;
            if (allZeros(alpha)) return true;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println(findPermutation("abc", "hdflebacworld"));

        System.out.println(findPermutation1("abbc", "hbbcadflebdworld"));
    }
}
