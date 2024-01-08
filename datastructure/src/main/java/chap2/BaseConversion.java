package chap2;

import java.util.ArrayDeque;
import java.util.Deque;

public class BaseConversion {

    public static void main(String[] args) {
        conversion(59, 2);
        conversion(59, 8);
        conversion(59, 16);
    }

    // 10진수 num을 base진법 수로 변환
    static void conversion(int num, int base) {
        System.out.print("10진수 " + num + "을 ");
        Deque<String> q = new ArrayDeque<>();

        while (num > 0) {
            if (base <= 10) {
                q.offer(String.valueOf(num % base));
                num /= base;
            }
            if (base > 10) {
                q.offer(exchange(num % base));
                num /= base;
            }

        }

        StringBuilder ans = new StringBuilder();
        while (!q.isEmpty()) {
            ans.append(q.pollLast());
        }

        System.out.println(base + "진법 수로 변환하면 : " + ans);
    }

    static String exchange(int a) {
        if (a <= 10) {
            return String.valueOf(a);
        }
        return String.valueOf((char) ((a - 10) + 'A'));
    }

}
