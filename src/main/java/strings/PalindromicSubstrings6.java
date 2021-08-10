package strings;

public class PalindromicSubstrings6 {

    private static int countPalindrom(String str, int l, int r) {
        int count = 0;
        while (l >= 0 && r < str.length()) {
            if (str.charAt(l) != str.charAt(r)) break;
            l--;
            r++;
            count++;
        }
        return count;
    }

    public static int countSubstrings(String str) {
        if (str == null || str.isEmpty()) return 0;

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += countPalindrom(str, i, i);
            count += countPalindrom(str, i, i + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abba"));
        System.out.println(countSubstrings("aabbbaa"));
    }
}
