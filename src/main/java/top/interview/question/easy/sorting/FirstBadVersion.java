package top.interview.question.easy.sorting;

import java.util.Random;

class Solution1 {

    Boolean isBadVersion(int version) {
        if (version > 20) return true;
        else return false;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

public class FirstBadVersion {
    public static void main(String[] args) {
        Solution1 s = new Solution1();

        System.out.println(s.firstBadVersion(5));
    }
}
