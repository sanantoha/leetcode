package dynamic;

public class HouseRobber {

    // O(n) time | O(1) space
    public static int rob(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        if (arr.length == 1) return arr[0];

        int fst = arr[0];
        int snd = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            int tmp = Math.max(fst + arr[i], snd);
            fst = snd;
            snd = tmp;
        }
        return snd;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,7,5,3,1}; // 14

        System.out.println(rob(nums));
    }
}
