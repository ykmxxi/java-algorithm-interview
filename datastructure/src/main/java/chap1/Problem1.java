package chap1;

public class Problem1 {

    public static void main(String[] args) {
        System.out.println(max4(10, 30, 20, 40)); // 40
        System.out.println(min4(20, 30, 40, 10)); // 10
    }

    static int max4(int a, int b, int c, int d) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        if (d > max) {
            max = d;
        }
        return max;
    }

    static int min4(int a, int b, int c, int d) {
        int min = a;
        if (min > b) {
            min = b;
        }
        if (min > c) {
            min = c;
        }
        if (min > d) {
            min = d;
        }
        return min;
    }

}
