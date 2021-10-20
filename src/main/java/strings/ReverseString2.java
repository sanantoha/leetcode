package strings;

public class ReverseString2 {

    // O(n) time | O(1) space
    public static void reverseString(char[] str) {
        if (str == null || str.length == 0) return;

        int l = 0;
        int r = str.length - 1;
        while (l < r) {
            char tmp = str[l];
            str[l] = str[r];
            str[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 't','l', 'l', 'o'};

        reverseString(s);

        System.out.println(String.valueOf(s));
    }
}
