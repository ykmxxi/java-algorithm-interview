package chap1;

import java.util.Scanner;

public class Problem3 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        sol1();
        sol2();
    }

    // a, b에 정수를 입력하고 b - a 출력, b <= a 이면 다시 입력
    static void sol1() {
        int a;
        int b;

        System.out.print("a값: ");
        a = sc.nextInt();
        System.out.print("b값: ");
        b = sc.nextInt();
        while (b <= a) {
            System.out.println("a보다 큰 값을 입력하세요!");
            System.out.print("b값: ");
            b = sc.nextInt();
        }

        System.out.println("b - a는 " + (b - a) + "입니다.");
    }

    // 양의 정수를 입력하고 자릿수를 출력
    static void sol2() {
        System.out.print("양의 정수를 입력하세요: ");
        int n = sc.nextInt();
        int ans = 0;

        while (n <= 0) {
            System.out.print("양의 정수를 입력하세요: ");
            n = sc.nextInt();
        }

        while (n > 0) {
            n /= 10;
            ans++;
        }
        System.out.println("그 수는 " + ans + "자리입니다.");
    }

}
