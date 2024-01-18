package chap5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem1 {

    static List<Integer> ans1 = new ArrayList<>();
    static List<Integer> ans2 = new ArrayList<>();

    static void rec(int n) {
        if (n > 0) {
            rec(n - 1);
            rec(n - 2);
            ans1.add(n);
        }
    }

    static void nonRec(int n) {
        Deque<Integer> dq1 = new ArrayDeque<>(); // n을 쌓아둘 스택
        Deque<Integer> dq2 = new ArrayDeque<>(); // 단계를 쌓아둘 스택

        while (true) {
            if (n > 0) { // rec(n - 1) 실행
                dq1.push(n);
                dq2.push(1);
                n = n - 1;
                continue;
            }

            if (dq2.peek() == 1) { // rec(n - 2) 실행
                dq2.pop();
                dq2.push(2);
                n = dq1.peek() - 2;
                continue;
            }
            if (!dq1.isEmpty() && dq2.peek() == 2) {
                ans2.add(dq1.pop());
                dq2.pop();
            }

            if (dq1.isEmpty()) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("==== 재귀적으로 구현한 알고리즘 ====");
        rec(5);
        System.out.println("ans1 = " + ans1);

        System.out.println("==== 비재귀적으로 구현한 알고리즘 ====");
        nonRec(5);
        System.out.println("ans2 = " + ans2);
    }

}
