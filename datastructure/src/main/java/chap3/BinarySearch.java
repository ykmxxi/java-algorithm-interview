package chap3;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 7, 8, 9, 12, 25, 35, 47, 63};

        int res = binarySearch(arr, 5);
        if (res == -1) {
            System.out.println();
        } else {
            System.out.println("값이 arr[" + res + "] 에 존재합니다.");
        }
    }

    static int binarySearch(int[] a, int key) {
        int l = 0;
        int r = a.length - 1;
        int mid;

        while (l < r) {
            mid = (l + r) / 2;
            if (a[mid] == key) {
                return mid;
            }
            if (a[mid] < key) {
                l = mid + 1;
            }
            r = mid - 1;
        }
        return -1;
    }

}
