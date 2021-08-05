package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int cntZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cntZero++;
            } else {
                product *= nums[i];
            }
        }

        int[] ans = new int[nums.length];
        if (cntZero > 1) {
            Arrays.fill(ans , 0);
        } else {
            for (int i = 0; i < nums.length; i++) {
                int v = nums[i];
                if (v == 0) {
                    ans[i] = product;
                } else if (cntZero > 0) {
                    ans[i] = 0;
                } else {
                    ans[i] = product / nums[i];
                }
            }
        }

        return ans;
    }

    public int[] productExceptSelf1(int[] nums) {
        if (nums.length == 1) return nums;

        int[] ans = new int[nums.length];
        ans[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }

        int r = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * r;
            r = r * nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf s = new ProductOfArrayExceptSelf();

        System.out.println(Arrays.toString(s.productExceptSelf(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(s.productExceptSelf1(new int[] {1,2,3,4})));


        System.out.println(Arrays.toString(s.productExceptSelf(new int[] {-1,1,0,-3,3})));
        System.out.println(Arrays.toString(s.productExceptSelf1(new int[] {-1,1,0,-3,3})));


        System.out.println(Arrays.toString(s.productExceptSelf(new int[] {0,1,0,-3,3})));
        System.out.println(Arrays.toString(s.productExceptSelf1(new int[] {0,1,0,-3,3})));
    }
}
