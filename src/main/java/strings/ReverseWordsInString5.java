package strings;

public class ReverseWordsInString5 {

    // O(n) time | O(n) space
    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);

        int start = 0;
        int end = 0;
        while (end < chars.length) {
            end = start;
            while (end < chars.length && chars[end] != ' ') {
                end++;
            }
            reverse(chars, start, end - 1);
            start = end + 1;
        }
        return String.valueOf(chars);
    }

    private static void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;
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
