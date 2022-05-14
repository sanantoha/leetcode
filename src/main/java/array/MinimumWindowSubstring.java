package array;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    // O(s + t) time | O(s + t) space
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return "";

        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            int cnt = dictT.getOrDefault(key, 0) + 1;
            dictT.put(key, cnt);
        }

        int formed = 0;
        int required = dictT.size();

        int l = 0;
        int r = 0;

        Map<Character, Integer> wc = new HashMap<>();

        int ansLength = Integer.MAX_VALUE;
        int ansL = 0;
        int ansR = 0;

        while (r < s.length()) {
            char c = s.charAt(r);

            int cnt = wc.getOrDefault(c, 0) + 1;
            wc.put(c, cnt);

            if (dictT.containsKey(c) && wc.get(c).equals(dictT.get(c))) {
                formed++;
            }

            while (l <= r && formed == required) {
                c = s.charAt(l);

                if (ansLength > r - l + 1) {
                    ansLength = r - l + 1;
                    ansR = r;
                    ansL = l;
                }

                cnt = wc.getOrDefault(c, 0) - 1;
                wc.put(c, cnt);

                if (dictT.containsKey(c) && wc.get(c) < dictT.get(c)) {
                    formed--;
                }

                l++;
            }

            r++;
        }

        return (ansLength == Integer.MAX_VALUE) ? "" : s.substring(ansL, ansR + 1);
    }

    /**
     * https://leetcode.com/explore/interview/card/apple/344/array-and-strings/2017/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC

        System.out.println(minWindow("a", "a")); // a

        System.out.println(minWindow("a", "aa")); // ""
    }
}
