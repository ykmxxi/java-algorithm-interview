package chap6.단순정렬;

import java.util.Arrays;

/**
 * 단순 선택 정렬
 * 1. 아직 정렬하지 않은 부분에서 가장 작은 값을 선택
 * 2. 가장 작은 값과 정렬하지 않은 부분의 첫 번째 요소를 교환
 * 3. 위 1, 2 과정을 n - 1번 반복
 * <p>
 * - Un-Stable 알고리즘
 * - 비교하는 횟수: (n^2 - n) / 2
 */
public class SelectionSort {

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }

        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static void main(String[] args) {
        selectionSort(new int[]{6, 4, 8, 3, 1, 9, 7});
    }

}
