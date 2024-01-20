package chap6.버블정렬;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // 한번 순회가 끝나면 arr[i]에 제일 작은 요소가 존재
            int swapCnt = 0; // swap 횟수
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) { // 이전 요소가 더 크면 swap
                    swap(arr, j - 1, j);
                    swapCnt++;
                }
                if (swapCnt == 0) { // swap이 발생하지 않으면 정렬이 완료된 상태. 끝까지 순회할 필요 없음
                    break;
                }
            }
        }
    }

    // 마지막 교환을 저장
    static void bubbleSort2(int[] arr) {
        int k = 0; // arr[k]보다 앞쪽은 정렬을 마친 상태
        while (k < arr.length - 1) {
            int last = arr.length - 1; // 마지막으로 요소를 교환한 위치
            for (int j = arr.length - 1; j > k; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    last = j;
                }
            }
            k = last;
        }
    }

    //--- 양방향 버블 정렬(셰이커 정렬)---//
    static void shakerSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int last = right;

        while (left < right) {
            for (int j = right; j > left; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    last = j;
                }
            }
            left = last;

            for (int j = left; j < right; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    last = j;
                }
            }
            right = last;
        }
    }

    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx2];
        arr[idx2] = arr[idx1];
        arr[idx1] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = create();
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        int[] arr3 = Arrays.copyOf(arr1, arr1.length);
        long start = System.currentTimeMillis();
        bubbleSort(arr1);
        long end = System.currentTimeMillis();
        System.out.println("10만개 bubble sort 시간: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        bubbleSort2(arr2);
        end = System.currentTimeMillis();
        System.out.println("10만개 bubble sort 시간: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        shakerSort(arr3);
        end = System.currentTimeMillis();
        System.out.println("10만개 shaker sort(양방향 버블) 시간: " + (end - start) + "ms");


    }

    static int[] create() {
        int[] arr = new int[100000];

        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000000);
        }
        return arr;
    }

}
