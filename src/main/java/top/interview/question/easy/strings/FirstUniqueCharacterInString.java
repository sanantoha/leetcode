package top.interview.question.easy.strings;

class Solution2 {
    public int firstUniqChar(String s) {
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean isDup = false;
            for (int j = 0; j < s.length(); j++) {
                char nc = s.charAt(j);
                if (i != j && c == nc) {
                    isDup = true;
                    break;
                }
            }
            if (!isDup) {
                return i;
            }
        }
        return res;
    }
}

public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        System.out.println(s.firstUniqChar("leetcode"));

        System.out.println(s.firstUniqChar("loveleetcode"));

        System.out.println(s.firstUniqChar("aabb"));
    }
}
