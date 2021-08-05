package top.interview.question.medium.sorting;


import java.util.Arrays;

class Solution0 {
    public void sortColors(int[] nums) {
        int redCnt = 0;
        int whiteCnt = 0;
        int blueCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                redCnt++;
            } else if (nums[i] == 1) {
                whiteCnt++;
            } else if (nums[i] == 2) {
                blueCnt++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (j < redCnt) {
                nums[j] = 0;
            } else if (j < redCnt + whiteCnt) {
                nums[j] = 1;
            } else if (j < redCnt + whiteCnt + blueCnt) {
                nums[j] = 2;
            }
        }
    }
}


public class SortColors {



    public static void main(String[] args) {
        Solution0 s = new Solution0();

        int[] arr = {2,0,2,1,1,0};

        s.sortColors(arr);

        System.out.println(Arrays.toString(arr));
    }
}
