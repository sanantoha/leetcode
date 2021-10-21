package strings;

public class ReverseWordsInString4 {

    // O(n) time | O(n) space
    public static String reverse(String src) {
        char[] srcChars = src.toCharArray();
        rev(srcChars, 0, srcChars.length - 1);

        int startIdx = 0;
        int endIdx = 0;
        while (endIdx < srcChars.length) {
            endIdx = startIdx;
            while (endIdx < srcChars.length && srcChars[endIdx] != ' ') {
                endIdx++;
            }
            rev(srcChars, startIdx, endIdx - 1);
            startIdx = endIdx + 1;
        }

        return String.valueOf(srcChars);
    }

    private static void rev(char[] src, int l, int r) {
        while (l < r) {
            char tmp = src[l];
            src[l] = src[r];
            src[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        String s = "the sky is blue";

        System.out.println(reverse(s));

        System.out.println('|' + reverse(" a good   example     ")+'|');

        System.out.println(reverse("this      string     has a     lot of   whitespace"));
    }
}
