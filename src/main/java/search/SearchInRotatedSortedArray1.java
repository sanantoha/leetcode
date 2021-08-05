package search;

public class SearchInRotatedSortedArray1 {

    private static int findSmallestInd(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < arr[r]) {
                r = mid;
            } else l = mid + 1;
        }
        return l;
    }

    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int smallest = findSmallestInd(arr);
        int l = 0;
        int r = arr.length - 1;
        if (target >= arr[smallest] && target <= arr[r]) {
            l = smallest;
        } else r = smallest - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (target <= arr[mid]) {
                r = mid - 1;
            } else l = mid + 1;
        }
        return arr[l] == target ? l : -(l + 1);
    }

    public static int search2(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (target == arr[mid]) return mid;

            if (arr[l] <= arr[mid]) {
                if (target >= arr[l] && target < arr[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[r]) {
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

        System.out.println(search(arr, 2));
        System.out.println(search2(arr, 2));
    }
}
