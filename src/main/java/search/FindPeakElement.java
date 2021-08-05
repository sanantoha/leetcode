package search;

public class FindPeakElement {

    public static int findPeakElement(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] < arr[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};

        System.out.println(findPeakElement(arr));
    }
}
