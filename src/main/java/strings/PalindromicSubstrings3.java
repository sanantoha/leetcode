package strings;

public class PalindromicSubstrings3 {



    public static int countSubstrings(String s) {
        int count = 0;
        if (s == null || s.length() == 0) return count;

        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }

        return count;
    }

    // O(n ^ 2) time | O(1) space
    private static int countPalindrome(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) break;
            count++;
            l--;
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aabbbaa"));
    }
}
