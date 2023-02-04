package strings;

public class OneEdit1 {

    public static boolean oneEdit(String s1, String s2) {
        return false;
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
