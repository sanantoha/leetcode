package strings;

public class ReverseWordsInString8 {

    // O(n) time | O(n) space
    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        reverse(arr, 0, arr.length - 1);

        int start = 0;
        int end = 0;

        while (end < str.length()) {
            end = start;
            while (end < str.length() && arr[end] != ' ') {
                end++;
            }
            reverse(arr, start, end - 1);
            start = end + 1;
        }
        return String.valueOf(arr);
    }

    private static void reverse(char[] arr, int l, int r) {

        while (l < r) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
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
