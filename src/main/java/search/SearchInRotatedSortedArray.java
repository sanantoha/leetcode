package search;

public class SearchInRotatedSortedArray {

    private static int findSmallestIdx(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] <= arr[r]) {
                r = mid - 1;
            } else l = mid + 1;
        }

        return l;
    }

    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int lo = 0;
        int hi = arr.length - 1;

        int smallInd = findSmallestIdx(arr);
        if (target >= arr[smallInd] && target <= arr[hi]) {
            lo = smallInd;
        } else {
            hi = smallInd - 1;
        }

        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (target > arr[mid]) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }

    public static int search2(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;

            if (target == arr[mid]) return mid;

            if (arr[l] <= arr[mid]) {
                if (target >= arr[l] && target < arr[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target <= arr[r] && target > arr[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};

        System.out.println(search(arr, 6));
        System.out.println(search2(arr, 6));
    }
}
