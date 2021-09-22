package strings;

public class ReverseWordsInString3 {

    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        int l = 0;
        int r = arr.length - 1;
        rev(arr, l, r);

        int start = 0;
        int end = 0;
        while (end < arr.length) {
            end = start;
            while (end < arr.length && arr[end] != ' ') {
                end++;
            }
            rev(arr, start, end - 1);
            start = end + 1;
        }

        return String.valueOf(arr);
    }

    private static void rev(char[] arr, int l, int r) {
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
