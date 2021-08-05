package top.interview.question.medium.array_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            List<String> lst = null;
            if (mp.containsKey(key)) {
                lst = mp.get(key);
            } else {
                lst = new ArrayList<>();
                mp.put(key, lst);
            }
            lst.add(str);
        }
        return new ArrayList<>(mp.values());
    }
}

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(s.groupAnagrams(strs));
    }
}
