package strings;

public class OneEdit {

    // O(n) time | O(1) space
    public static boolean oneEdit(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) return false;
        int l1 = s1.length();
        int l2 = s2.length();

        if (Math.abs(l1 - l2) > 1) return false;

        int i = 0;
        int j = 0;

        boolean makeEdit = false;

        while (i < l1 && j < l2) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (makeEdit) return false;

                makeEdit = true;

                if (l1 > l2) {
                    i++;
                } else if (l1 < l2) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }

        return makeEdit;
    }

    public static void main(String[] args) {
        String stringOne = "hello";
        String stringTwo = "helo";
        boolean expected = true;
        var actual = oneEdit(stringOne, stringTwo);
        System.out.println(actual);
        System.out.println(actual == expected);
    }
}
