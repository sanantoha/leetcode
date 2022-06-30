package sorting;

public class KthSmallestElementInArray1 {

    public static int kthSmallestElement(int[] arr, int k) {
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {8,2,1,6,9,3,45,6,7,13};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(kthSmallestElement(arr, i + 1));
        }

        System.out.println(kthSmallestElement(arr, -1));
        System.out.println(kthSmallestElement(arr, 0));
        System.out.println(kthSmallestElement(arr, 11));
    }
}
