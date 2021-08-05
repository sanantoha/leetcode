package top.interview.question.easy.others;

class Solution0 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        String binary = Integer.toBinaryString(n);
        for (int i = 0; i < binary.length(); i++) {
            char k = binary.charAt(i);
            if (k == '1') result++;
        }
        return result;
    }

    public int hammingWeight0(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}

public class NumberOfOneBits {
    public static void main(String[] args) {
        Solution0 s = new Solution0();

        System.out.println(s.hammingWeight(0b00000000000000000000000000001011));
    }
}
