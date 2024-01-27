package chap6.퀵정렬;

import java.util.Arrays;

public class QuickSort {

    static void quickSort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int x = arr[(pl + pr) / 2];

        do {
            while (arr[pl] < x) {
                pl++;
            }
            while (arr[pr] > x) {
                pr--;
            }
            if (pl <= pr) {
                swap(arr, pl, pr);
                pl++;
                pr--;
            }
        } while (pl <= pr);

        if (left < pr) {
            quickSort(arr, left, pr); // 왼쪽 그룹
        }
        if (pl < right) {
            quickSort(arr, pl, right); // 오른쪽 그룹
        }
    }

    static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 7, 4, 5, 2, 6, 3, 9};
        System.out.println("오름차순 퀵 정렬 전 = " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("오름차순 퀵 정렬 후 = " + Arrays.toString(arr));
    }

}
