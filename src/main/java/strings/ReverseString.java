package strings;

public class ReverseString {

    // O(n) time | O(1) space
    public static void reverseString(char[] s) {
        if (s == null || s.length == 0) return;

        int l = 0;
        int r = s.length - 1;

        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};

        reverseString(s);

        System.out.println(String.valueOf(s));
    }
}
