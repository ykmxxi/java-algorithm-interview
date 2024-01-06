package chap1;

public class Problem5 {

    public static void main(String[] args) {
        spira(4);

        System.out.println();

        npira(4);
    }

    static void spira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2 * n - 1; j++) {
                if (j == n) {
                    System.out.print("*");
                } else if (j > n - i && j < n + i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void npira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2 * n - 1; j++) {
                if (j == n) {
                    System.out.print(i % 10);
                } else if (j > n - i && j < n + i) {
                    System.out.print(i % 10);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
