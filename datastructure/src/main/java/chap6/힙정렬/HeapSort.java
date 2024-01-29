package chap6.힙정렬;

import java.util.Arrays;

public class HeapSort {

    // a[left] ~ a[right] 힙으로 변경
    static void downHeap(int[] a, int left, int right) {
        int tmp = a[left]; // 루트
        int child;
        int parent;

        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int leftChild = parent * 2 + 1;
            int rightChild = leftChild + 1;

            child = (rightChild <= right && a[rightChild] > a[leftChild]) ? rightChild : leftChild; // 자식 중 큰 쪽을 대입
            if (tmp >= a[child]) {
                break;
            }
            a[parent] = a[child];
        }
        a[parent] = tmp;
    }

    static void heapSort(int[] a) {
        int n = a.length;

        // 배열을 힙으로 변경
        for (int i = (n - 1) / 2; i >= 0; i--) {
            downHeap(a, i, n - 1);
        }

        // 가장 큰 요소와 정렬되지 않은 부분의 마지막 요소를 교환하고 가장 큰 요소를 제외한 부분을 다시 힙으로 변경
        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            downHeap(a, 0, i - 1);
        }
    }

    static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 7, 1, 9, 8};
        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }

}
