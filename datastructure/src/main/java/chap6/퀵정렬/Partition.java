package chap6.퀵정렬;

public class Partition {

    static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    static void partition(int[] arr) {
        int pl = 0; // 왼쪽 커서
        int pr = arr.length - 1; // 오른쪽 커서
        int x = arr[arr.length / 2]; // pivot

        do {
            while (arr[pl] < x) {
                pl++;
            }
            while (arr[pr] > x) {
                pr--;
            }

            if (pl <= pr) {
                swap(arr, pl++, pr--);
            }
        } while (pl <= pr);

        System.out.println("pivot = " + x);
        System.out.println("pivot 보다 같거나 작은 그룹 : ");
        for (int i = 0; i < pl; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        if (pl > pr + 1) {
            System.out.println("pivot과 값이 같은 그룹 : ");
            for (int i = pr + 1; i < pl; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
        System.out.println("pivot 보다 같거나 큰 그룹 : ");
        for (int i = pr + 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        System.out.println("pl = " + pl + ", pr = " + pr);
    }

    public static void main(String[] args) {
        partition(new int[]{1, 8, 7, 4, 5, 2, 6, 3, 9});
    }

}
