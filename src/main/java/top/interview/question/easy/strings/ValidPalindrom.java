package top.interview.question.easy.strings;

class Solution4 {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < s.length() && j >= 0) {
            if (i == j) break;

            char l = s.charAt(i);
            if (!Character.isAlphabetic(l) && !Character.isDigit(l)) {
                i++;
                continue;
            }
            char r = s.charAt(j);
            if (!Character.isAlphabetic(r) && !Character.isDigit(r)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(l) == Character.toLowerCase(r)) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }
}

public class ValidPalindrom {
    public static void main(String[] args) {
        Solution4 s = new Solution4();


        String str = "A man, a plan, a canal: Panama";
//        System.out.println(s.isPalindrome(str));

        String str1 = "race a car";
//        System.out.println(s.isPalindrome(str1));

//        String str2 = "0P";
//        System.out.println(s.isPalindrome(str2));


        String str3 = "ab2a";
        System.out.println(s.isPalindrome(str3));
    }
}
