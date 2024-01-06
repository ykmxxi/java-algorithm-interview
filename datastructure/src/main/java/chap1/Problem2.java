package chap1;

public class Problem2 {

    public static void main(String[] args) {
        System.out.println(gaussAddition(10)); // 55
        System.out.println(gaussAddition(11)); // 66

        System.out.println(sumOf(3, 5)); // 12
        System.out.println(sumOf(6, 4)); // 15
        System.out.println(sumOf(8, 5)); // 26
    }

    // 세 값의 중앙값
    static int med3(int a, int b, int c) {
        if (a >= b) {
            if (b >= c) {
                return b;
            } else if (c >= a) {
                return a;
            } else {
                return c;
            }
        } else if (a > c) {
            return a;
        } else if (b > c) {
            return c;
        } else {
            return b;
        }
    }

    // 가우스의 덧셈
    static int gaussAddition(int n) {
        int a = n % 2 == 1 ? (n + 1) / 2 : 0;
        return (1 + n) * (n / 2) + a;
    }

    // a,b 포함 그 사이의 모든 정수의 합
    static int sumOf(int a, int b) {
        int c = (Math.abs(a - b) + 1) % 2 == 1 ? (a + b) / 2 : 0;
        return (a + b) * ((Math.abs(a - b) + 1) / 2) + c;
    }

}
