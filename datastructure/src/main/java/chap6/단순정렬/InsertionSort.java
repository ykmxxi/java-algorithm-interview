package chap6.단순정렬;

import java.util.Arrays;

/**
 * 단순 삽입 정렬
 * <p>
 * 1. 요소를 선택해 저장하고 왼쪽으로 이동하며 본인보다 작은 요소를 만날 때 까지 오른쪽으로 한 칸씩 옮긴다 <p>
 * 2. 본인보다 작은 요소를 만나면 그 옆에 대입 <p>
 * 3. 이 과정을 끝까지 반복 <p>
 * <p>
 * - 비교 횟수와 교환 횟수: n^2 / 2 <p>
 * - Stable 알고리즘: 이웃한 요소를 차례대로 비교하기 때문에 순서가 보장
 */
public class InsertionSort {

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j;
            int tmp = arr[i];

            for (j = i; j > 0 && arr[j - 1] > tmp; j--) { // tmp 보다 작은 요소를 만날 때 까지 왼쪽으로 이동하며
                arr[j] = arr[j - 1]; // 왼쪽 요소를 한 칸 오른쪽에 대입
            }
            arr[j] = tmp; // 알맞은 위치를 찾으면 대입
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        insertionSort(new int[]{6, 4, 8, 3, 1, 9, 7});
    }

}
