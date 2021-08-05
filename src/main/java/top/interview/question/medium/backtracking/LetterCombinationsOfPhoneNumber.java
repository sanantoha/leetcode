package top.interview.question.medium.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution0 {

    private final static Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }


    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();

        LinkedList<String> lst = new LinkedList<>();
        lst.add("");

        for (int i = 0; i < digits.length(); i++) {
            while (lst.peek().length() == i) {
                String t = lst.remove();
                for (char c : map.get(digits.charAt(i)).toCharArray()) {
                    lst.add(t + c);
                }
            }
        }

        return lst;
    }

    public List<String> letterCombinations1(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;

        letterCombinationsRec(result, digits, "", 0);
        return result;
    }

    private void letterCombinationsRec(List<String> result, String digits, String curr, int ind) {
        if (ind == digits.length()) {
            result.add(curr);
            return;
        }
        String letters = map.get(digits.charAt(ind));
        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsRec(result, digits, curr + letters.charAt(i), ind + 1);
        }
    }
}

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        Solution0 s = new Solution0();

        System.out.println(s.letterCombinations("23"));
        System.out.println(s.letterCombinations1("23"));
//
//        // ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg",
//        // "bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
        System.out.println(s.letterCombinations("234"));
        System.out.println(s.letterCombinations1("234"));
//
        System.out.println(s.letterCombinations("2"));
        System.out.println(s.letterCombinations1("2"));
        System.out.println(s.letterCombinations(""));
        System.out.println(s.letterCombinations1(""));
    }
}
