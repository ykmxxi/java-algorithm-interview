package chap2;

import java.util.Arrays;
import java.util.Random;

public class Problem2 {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[7];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(21);
            System.out.println(i + "번 요소: " + arr[i]);
        }

        reverse(arr);

        System.out.println("배열의 모든 요소의 합 = " + sumOf(arr));

        copy(new int[arr.length], arr);
        reverseCopy(new int[arr.length], arr);

    }

    // 역순 정렬과정 표시
    static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            System.out.println("arr[" + i + "]과 arr[" + (arr.length - i - 1) + "]을 교환합니다.");
            swap(arr, i, arr.length - i - 1);
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("역순 정렬을 마쳤습니다.");
    }

    static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    static int sumOf(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        return sum;
    }

    // b의 모든 요소를 a에 복사
    static void copy(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }
        System.out.println("복사한 배열 = " + Arrays.toString(a));
    }

    // b의 모든 요소를 배열 a에 역순으로 복사
    static void reverseCopy(int[] a, int[] b) {
        for (int i = 0; i < b.length / 2; i++) {
            a[i] = b[b.length - i - 1];
            a[b.length - i - 1] = b[i];
        }
        System.out.println("역순으로 복사한 배열 = " + Arrays.toString(a));
    }

}
