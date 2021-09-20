package strings;

public class PalindromicSubstrings {

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

    // O(n ^ 2) time | O(1) space
    public static int countSubstrings(String s) {
        int count = 0;
        if (s == null || s.isEmpty()) return count;

        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i); // for odd
            count += countPalindrome(s, i, i + 1); // for even
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc")); // 3

        System.out.println(countSubstrings("aaa")); // 6

        System.out.println(countSubstrings("aabbbaa")); // 14

        System.out.println(countSubstrings("aaab")); // 7
    }
}
