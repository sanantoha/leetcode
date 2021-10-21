package strings;

public class ReverseWordsInString {

    // O(n) time | O(n) space
    public static String reverseWords(String s) {
        if (s == null || s.isEmpty()) return "";

        String[] arr = s.trim().split("\\s+");

        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            String tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }

        return sb.substring(0, sb.length() - 1);
    }

    // O(n) time | O(n) space
    public static String reverseWordsInString(String string) {
        char[] chars = string.toCharArray();
        reverseSubStr(chars, 0, chars.length - 1);

        int startOfWord = 0;
        while (startOfWord < chars.length) {
            int endOfWord = startOfWord;
            while (endOfWord < chars.length && chars[endOfWord] != ' ') {
                endOfWord++;
            }
            reverseSubStr(chars, startOfWord, endOfWord - 1);
            startOfWord = endOfWord + 1;
        }

        return String.valueOf(chars);
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void reverseSubStr(char[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        String s = "the sky is blue";

        System.out.println(reverseWordsInString(s));

        System.out.println('|' + reverseWordsInString("a good   example     ")+'|');

        System.out.println(reverseWordsInString("this      string     has a     lot of   whitespace"));
    }
}
