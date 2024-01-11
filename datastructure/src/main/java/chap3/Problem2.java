package chap3;

public class Problem2 {

    static int binSearchX(int[] a, int key) {
        int l = 0;
        int r = a.length - 1;
        int m;

        while (l < r) {
            m = (l + r) / 2;
            if (a[m] == key) {
                int ans = m;
                for (int i = m - 1; i >= 0; i--) {
                    if (a[i] == key) {
                        ans = i;
                        continue;
                    }
                    break;
                }
                return ans;
            }
            if (a[m] < key) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

}
