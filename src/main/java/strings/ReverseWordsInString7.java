package strings;

public class ReverseWordsInString7 {

    // O(n) time | O(n) space
    public static String reverse(String str) {
        if (str == null || str.isEmpty()) return str;

        char[] arr = str.toCharArray();
        reverse(arr, 0, arr.length - 1);

        int startIdx = 0;
        while (startIdx < arr.length) {
            int endIdx = startIdx;
            while (endIdx < arr.length && arr[endIdx] != ' ') {
                endIdx++;
            }
            reverse(arr, startIdx, endIdx - 1);
            startIdx = endIdx + 1;
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
