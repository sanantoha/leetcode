package search;

public class FindPeakElement1 {

    private static int findPeak(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return arr[l];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,4,5,6,5,4,3,2,1};

        System.out.println(findPeak(arr));
    }
}
