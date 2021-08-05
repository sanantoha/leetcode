package top.interview.question.easy.others;

class Solution2 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int maskL = 1;
        int maskR = 1 << 31;
        int i = 0;
        int j = 31;
        while (i < 16 && j >= 16) {
            if ((n & maskL) != 0 && (n & maskR) == 0) {
                n |= maskR;
                n &= ~maskL;
            } else if ((n & maskL) == 0 && (n & maskR) != 0) {
                n &= ~maskR;
                n |= maskL;
            }
            i++;
            j--;
            maskL <<= 1;
            maskR = 1 << j;
        }
        return n;
    }
}

public class ReverseBits {
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        int v = s.reverseBits(0b00000010100101000001111010011100);
        System.out.println(v);
        System.out.println(Integer.toBinaryString(v));
//        System.out.println(0b10111111111111111111111111111111);

//        int n = 1;
//        n <<= 3;
//        System.out.println(Integer.toBinaryString(n));
//        int k = 1 << 31;
//        System.out.println(Integer.toBinaryString(k));
//        System.out.println(Integer.toBinaryString(k >> 2));
    }
}
