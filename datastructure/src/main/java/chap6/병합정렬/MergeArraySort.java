package chap6.병합정렬;

import java.util.Arrays;

public class MergeArraySort {

    /**
     * 시간 복잡도: O(n)
     */
    static void merge(int[] a, int[] b, int[] c) {
        int pa = 0; // a 배열 커서
        int pb = 0; // b 배열 커서
        int pc = 0; // c 배열(a, b 병합 배열) 커서

        while (pa < a.length && pb < b.length) {
            c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
        }

        while (pa < a.length) { // 남아 있는 요소 복사
            c[pc++] = a[pa++];
        }

        while (pb < b.length) { // 남아 있는 요소 복사
            c[pc++] = b[pb++];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9};
        int[] b = {2, 4, 6, 8, 10};
        int[] c = new int[10];

        merge(a, b, c);
        System.out.println(Arrays.toString(c));
    }

}
