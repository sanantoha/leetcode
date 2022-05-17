package array;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

    // O(n) time | O(1) space - space 1 because english alphabet contains only 26 letters
    public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cnt = map.getOrDefault(c, 0) + 1;
            map.put(c, cnt);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * https://leetcode.com/explore/interview/card/apple/344/array-and-strings/2018/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode")); //0

        System.out.println(firstUniqChar("loveleetcode")); //2

        System.out.println(firstUniqChar("aabb")); // -1
    }
}
