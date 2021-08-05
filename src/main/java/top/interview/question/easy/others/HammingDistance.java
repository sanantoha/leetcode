package top.interview.question.easy.others;

class Solution1 {

    public int hammingDistance(int x, int y) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((x & mask) != (y & mask)) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}

public class HammingDistance {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.hammingDistance(1, 4));
    }
}
