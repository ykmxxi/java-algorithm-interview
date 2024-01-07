package chap2;

import java.util.Arrays;
import java.util.Random;

public class ReverseArray {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[8];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(21);
            System.out.println(i + "번 요소: " + arr[i]);
        }

        reverse(arr);

        System.out.println("요소의 순서를 역순으로 정렬: 0 -> n-1, n-1 -> 0");
        System.out.println("arr = " + Arrays.toString(arr));
    }

    static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, arr.length - i - 1);
        }
    }

    static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

}
