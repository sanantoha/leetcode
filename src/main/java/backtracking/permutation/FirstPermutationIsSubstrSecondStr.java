package backtracking.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstPermutationIsSubstrSecondStr {

    private static List<String> permutation(String s) {
        List<String> ans = new ArrayList<>();
        permute(s, "", ans);
        return ans;
    }

    private static void permute(String s, String answer, List<String> ans) {

        if (s.length() == 0) {
            ans.add(answer);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String l = s.substring(0, i);
            String r = s.substring(i + 1);
            permute(l + r, answer + ch, ans);
        }
    }

    public static boolean findPermutation(String s1, String s2) {
        for (String permute : permutation(s1)) {
            if (s2.contains(permute)) return true;
        }
        return false;
    }


    /**
     * sliding window
     * @param s1
     * @param s2
     * @return
     */
    public static boolean findPermutation1(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] alpha = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            alpha[s1.charAt(i) - 'a']++;
        }

        System.out.println(Arrays.toString(alpha));

        for (int i = 0; i < s2.length(); i++) {
            alpha[s2.charAt(i) - 'a']--;

            if(i - s1.length() >= 0) alpha[s2.charAt(i - s1.length()) - 'a']++;
            if (allZeros(alpha)) return true;
        }

        return false;
    }

    private static boolean allZeros(int[] alpha) {
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] != 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
//        System.out.println(backtracking.permutation("abc"));

        System.out.println(findPermutation("ab", "hdflebaworld"));

        System.out.println(findPermutation1("abbc", "hbbcadflebdworld"));

        // try sliding window approach
    }
}
