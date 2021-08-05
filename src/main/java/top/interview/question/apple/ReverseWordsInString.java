package top.interview.question.apple;

import java.util.Arrays;

public class ReverseWordsInString {

    public static String reverseWords(String s) {
        if (s.isEmpty()) return "";

        String[] ss = s.split("\\s+");

        int start = 0;
        int end = ss.length - 1;
        while (start < end) {

            String tmp = ss[start];
            ss[start] = ss[end];
            ss[end] = tmp;
            start++;
            end--;
        }

        StringBuilder sb = new StringBuilder();
        for (String word : ss) {
            sb.append(word).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }


    public static void main(String[] args) {
        String s = "the sky is blue";

        System.out.println(reverseWords(s));

        System.out.println('|' + reverseWords("a good   example     ")+'|');
    }
}
