package chap3;

public class Problem1 {

    static int seqSearch(int[] a, int n, int key) {
        int i = 0;
        a[n] = key;

        for (; true; ) {
            if (a[i] == key) {
                break;
            }
            i++;
        }
        return i == n ? -1 : i;
    }

}
