package top.interview.question.apple;

public class SplitStringInBalancedStrings {

    public int balancedStringSplit(String s) {
        int balancedString = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') count++;
            else if (c == 'R') count--;

            if (count == 0) balancedString++;
        }

        return balancedString;
    }

    public static void main(String[] args) {
        SplitStringInBalancedStrings s = new SplitStringInBalancedStrings();

        System.out.println(s.balancedStringSplit("RLRRLLRLRL"));
    }
}
