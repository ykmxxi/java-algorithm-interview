package chap6.셸정렬;

import java.util.Arrays;

public class ShellSort {

    static void shellSort(int[] arr) {
        int n = arr.length;

        for (int h = n / 2; h > 0; h /= 2) { // h칸 만큼 떨어져있는 요소끼리 비교
            for (int i = h; i < n; i++) {
                int j;
                int tmp = arr[i];
                for (j = i - h; j >= 0 && arr[j] > tmp; j -= h) {
                    arr[j + h] = arr[j];
                }
                arr[j + h] = tmp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        shellSort(new int[]{6, 4, 3, 7, 1, 9, 8});
    }

}
