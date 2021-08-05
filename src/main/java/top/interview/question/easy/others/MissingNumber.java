package top.interview.question.easy.others;

class Solution5 {
    public int missingNumber(int[] nums) {
        int expSum = (nums.length + 1) * (nums.length) / 2;
        int actSum = 0;
        for (int num : nums) {
            actSum += num;
        }
        return expSum - actSum;
    }
}

public class MissingNumber {
    public static void main(String[] args) {
        Solution5 s = new Solution5();

        int[] arr = {9,6,4,2,3,5,7,0,1};

        System.out.println(s.missingNumber(arr));

        int[] arr1 = {3,0,1};
        System.out.println(s.missingNumber(arr1));

        int[] arr2 = {0,1};
        System.out.println(s.missingNumber(arr2));

        int[] arr3 = {0};
        System.out.println(s.missingNumber(arr3));
    }
}
