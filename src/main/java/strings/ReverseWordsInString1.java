package strings;

public class ReverseWordsInString1 {

    public static String reverse(String str) {
        if (str == null || str.isEmpty()) return str;
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);

        int start = 0;
        int end = 0;
        while (start < chars.length) {
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
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        String s = "the sky is blue";

        System.out.println(reverse(s));

        System.out.println('|' + reverse("a good   example     ")+'|');

        System.out.println(reverse("this      string     has a     lot of   whitespace"));
    }
}
