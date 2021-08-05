package top.interview.question.easy.strings;

class Solution7 {
    public String countAndSay0(int n) {
        if (n == 1) return "1";

        String s = countAndSay0(n - 1);
        char first = s.charAt(0);
        int cnt = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == first) {
                cnt++;
            } else {
                res.append(cnt).append(first);
                cnt = 1;
                first = s.charAt(i);
            }
        }
        res.append(cnt).append(first);
        return res.toString();
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";


        String[] dp = new String[n];
        dp[0] = "1";

        for (int j = 1; j < n; j++) {
            String s = dp[j - 1];
            char first = s.charAt(0);
            int cnt = 0;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == first) {
                    cnt++;
                } else {
                    res.append(cnt).append(first);
                    cnt = 1;
                    first = s.charAt(i);
                }
            }
            res.append(cnt).append(first);
            dp[j] = res.toString();
        }

        return dp[n - 1];
    }
}

public class CountAndSay {
    public static void main(String[] args) {
        Solution7 s = new Solution7();

        for (int i = 1; i <= 10; i++) {
            System.out.println(s.countAndSay(i));
        }
    }
}
