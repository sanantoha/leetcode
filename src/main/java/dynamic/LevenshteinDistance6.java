package dynamic;

public class LevenshteinDistance6 {

    // O(s1 * s2) time | O(s1 * s2) length
    public static int levenshteinDistance(String str1, String str2) {
        if ((str1 == null || str1.isEmpty()) && (str2 == null || str2.isEmpty())) {
            return 0;
        }
        if (str1 == null || str1.isEmpty()) return str2.length();
        if (str2 == null || str2.isEmpty()) return str1.length();

        int[][] ld = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            ld[i][0] = i;
        }
        for (int i = 0; i <= str2.length(); i++) {
            ld[0][i] = i;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    ld[i][j] = ld[i - 1][j - 1];
                } else {
                    ld[i][j] = 1 + Math.min(Math.min(ld[i - 1][j], ld[i][j - 1]), ld[i - 1][j - 1]);
                }
            }
        }
        return ld[str1.length()][str2.length()];
    }

    // O(s1 * s2) time | O(min(s1, s2)) space
    public static int levenshteinDistance1(String str1, String str2) {
        if ((str1 == null || str1.isEmpty()) && (str2 == null || str2.isEmpty())) {
            return 0;
        }
        if (str1 == null || str1.isEmpty()) return str2.length();
        if (str2 == null || str2.isEmpty()) return str1.length();

        String small = (str1.length() > str2.length()) ? str2 : str1;
        String big = (str1.length() > str2.length()) ? str1 : str2;

        int[] even = new int[small.length() + 1];
        for (int i = 0; i <= small.length(); i++) {
            even[i] = i;
        }

        int[] odd = new int[small.length() + 1];

        int[] current;
        int[] prev;

        for (int i = 1; i <= big.length(); i++) {
            if (i % 2 == 1) {
                current = odd;
                prev = even;
            } else {
                current = even;
                prev = odd;
            }
            current[0] = i;
            for (int j = 1; j <= small.length(); j++) {
                if (big.charAt(i - 1) == small.charAt(j - 1)) {
                    current[j] = prev[j - 1];
                } else {
                    current[j] = 1 + Math.min(Math.min(prev[j - 1], prev[j]), current[j - 1]);
                }
            }
        }

        return (big.length() % 2 == 0) ? even[small.length()] : odd[small.length()];
    }


    public static void main(String[] args) {
        System.out.println(levenshteinDistance("abc", "yabd") == 2);
        System.out.println(levenshteinDistance1("abc", "yabd") == 2);
    }
}
