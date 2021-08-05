package top.interview.question.easy.strings;

class Solution5 {

    public String rtrim(String s) {
        int i = s.length()-1;
        while (i >= 0 && !Character.isDigit(s.charAt(i)) ) {
            i--;
        }
        return s.substring(0, i+1);
    }

    public int myAtoi(String s) {
        String src = rtrim(s.trim());
        StringBuilder res = new StringBuilder();
        boolean negative = false;
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);

            if ((c == '+' || c == '-') && i > 0) {
                break;
            } else if (c == ' ') {
                break;
            } else if (c == '-') {
                negative = true;
            } else if (Character.isDigit(c)) {
                res.append(c);
            }else if (c == '.' || Character.isAlphabetic(c)) {
                break;
            }
        }
        try {
            double resV = Double.parseDouble(res.toString());
            resV = (negative) ? -resV : resV;
            if (resV > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (resV < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else return (int) resV;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

public class StringToInteger {
    public static void main(String[] args) {
        Solution5 s = new Solution5();

//        String str0 = "21474836460";
//
//        System.out.println(s.myAtoi(str0));
//
//        String str = "-91283472332";
//
//        System.out.println(s.myAtoi(str));
//
//        String str1 = "4193 with words";
//
//        System.out.println(s.myAtoi(str1));
//
//        String str2 = "3.14159";
//
//        System.out.println(s.myAtoi(str2));
//
//        String str3 = "  -0012a42";
//
//        System.out.println(s.myAtoi(str3));
//
//        String str4 = "+-12";
//
//        System.out.println(s.myAtoi(str4));

        String str5 = "20000000000000000000";
        System.out.println(s.myAtoi(str5));
    }
}
