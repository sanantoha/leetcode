package dynamic;

public class LevenshteinDistance2 {

    // O(n * m) time | O(n * m) space
    public static int levenshteinDistance(String str1, String str2) {
        if ((str1 == null || str1.length() == 0) && (str2 == null || str2.length() == 0)) {
            return 0;
        }
        if (str1 == null || str1.length() == 0) return str2.length();
        if (str2 == null || str2.length() == 0) return str1.length();

        int[][] distances = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length() + 1; i++) {
            distances[i][0] = i;
        }
        for (int i = 0; i < str2.length() + 1; i++) {
            distances[0][i] = i;
        }

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    distances[i][j] = distances[i - 1][j - 1];
                } else {
                    distances[i][j] = Math.min(
                            Math.min(distances[i - 1][j], distances[i][j - 1]),
                            distances[i - 1][j - 1]
                    ) + 1;
                }
            }
        }

        return distances[str1.length()][str2.length()];
    }

    // O(n * m) time | O(min(n, m)) space
    public static int levenshteinDistance1(String str1, String str2) {
        if ((str1 == null || str1.length() == 0) && (str2 == null || str2.length() == 0)) {
            return 0;
        }
        if (str1 == null || str1.length() == 0) return str2.length();
        if (str2 == null || str2.length() == 0) return str1.length();

        String small = (str1.length() < str2.length()) ? str1 : str2;
        String big = (str1.length() < str2.length()) ? str2 : str1;

        int[] even = new int[small.length() + 1];
        for (int i = 0; i < small.length() + 1; i++) {
            even[i] = i;
        }
        int[] odd = new int[small.length() + 1];

        int[] current;
        int[] prev;

        for (int i = 1; i < big.length() + 1; i++) {
            if (i % 2 == 0) {
                current = even;
                prev = odd;
            } else {
                current = odd;
                prev = even;
            }
            current[0] = i;
            for (int j = 1; j < small.length() + 1; j++) {
                if (big.charAt(i - 1) == small.charAt(j - 1)) {
                    current[j] = prev[j - 1];
                } else {
                    current[j] = 1 + Math.min(
                            Math.min(prev[j - 1], prev[j]),
                            current[j - 1]
                    );
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
