package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty
 * words, determine if s can be segmented into a space-separated sequence of one or more
 * dictionary words
 *
 * Input:
 * s: "facebook"
 * wordDict: ["face", "book", "one", "two", "facebook"]
 */
public class SegmentedIntoSeqWords {

    public static List<String> segment(String s, Set<String> words) {

        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                if (words.contains(str)) {
                    ans.add(str);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Set<String> words = Set.of("face", "book", "one", "two", "facebook", "oo");

        System.out.println(segment("facebook", words));
    }
}
