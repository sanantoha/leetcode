package top.interview.question.medium.dynamic;

class Solution0 {
    public boolean canJump0(int[] nums) {
        int index = 0;

        while (index < nums.length) {
            if (index >= nums.length - 1) return true;
            int step = nums[index];
            if (step == 0) break;
            index += step;
        }

        if (index >= nums.length - 1) return true;
        return false;
    }

    public boolean canJump(int[] nums) {
        int j = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= j) {
                j = i;
            }
        }
        return j == 0;
    }
}

public class JumpGame {
    public static void main(String[] args) {
        Solution0 s = new Solution0();

        int[] arr = {2,3,1,1,4};

        System.out.println(s.canJump(arr));

        int[] arr1 = {3,2,1,0,4};

        System.out.println(s.canJump(arr1));

        int[] arr2 = {2, 0};
        System.out.println(s.canJump(arr2));

        int[] arr3 = {0};
        System.out.println(s.canJump(arr3));

        int[] arr4 = {2, 0, 0};
        System.out.println(s.canJump(arr4));

        int[] arr5 = {2,5,0,0};
        System.out.println(s.canJump(arr5));
    }
}
