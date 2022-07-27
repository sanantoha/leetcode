package array;

/**
 * You are given a binary string s, consisting of characters '0' or '1'. Transform this string into
 * a palindrome by performing some operations. In the operation, swap any two characters, s[i] and s[j],
 * Determine the minimum number of swaps required to make the string a palindrome. if it is impossible
 * to do so, then return -1.
 *
 * Example
 * Let string s = "0100101". The following shows the minimum number of steps required. It uses 1 based
 * indexing.
 *  - swap characters with indices (1, 2)
 *  - swap characters with indices (4, 5)
 *  result 2
 */
public class MinSwapsTransformStringToPalindrome {

    // O(n) time | O(1) space
    private static int minSwapsRequired(String s) {
        if (s == null || s.length() == 0) return -1;

        int l = 0;
        int r = s.length() - 1;

        int num = 0;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                num++;
            }
            l++;
            r--;
        }

        if (num % 2 == 1 && s.length() % 2 == 0) {
            return -1;
        }
        return (num + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(minSwapsRequired("0100101") == 2);

        System.out.println(minSwapsRequired("1110") == -1); // no way to make s a palindrome

        System.out.println(minSwapsRequired("11101") == 1);
    }
}
