package chap5;

import java.util.Stack;

public class RemoveRecursive {

    static int cnt = 0;
    static Stack<Integer> s = new Stack<>();
    static String[] memo;

    static void rec(int n) {
        cnt++;
        if (n > 0) {
            rec(n - 1);
            System.out.println(n);
            rec(n - 2);
        }
    }

    // 꼬리 재귀 제거
    static void removeRetailRec(int n) {
        cnt++;
        while (n > 0) {
            rec(n - 1);
            System.out.println(n);
            n = n - 2;
        }
    }

    // 앞 뒤 재귀 제거
    static void removeAllRec(int n) {
        cnt++;
        while (true) {
            if (n > 0) {
                s.push(n);
                n = n - 1;
                continue;
            }
            if (!s.isEmpty()) {
                n = s.pop();
                System.out.println(n);
                n = n - 2;
                continue;
            }
            break;
        }
    }

    // 메모화 기법 사용
    static void memoization(int n) {
        cnt++;
        if (memo[n + 1] != null) {
            System.out.print(memo[n + 1]);
            return;
        }
        if (n > 0) {
            memoization(n - 1);
            System.out.println(n);
            memoization(n - 2);
            memo[n + 1] = memo[n] + n + "\n" + memo[n - 1]; // 메모화
        } else {
            memo[n + 1] = ""; // memoization(0), memoization(-1) -> 빈 문자열
        }
    }

    public static void main(String[] args) {
        rec(10);
        System.out.println("호출 횟수: " + cnt);
        cnt = 0;
        System.out.println("===================");

        removeRetailRec(10);
        System.out.println("호출 횟수: " + cnt);
        cnt = 0;
        System.out.println("===================");

        removeAllRec(10);
        System.out.println("호출 횟수: " + cnt);
        cnt = 0;
        System.out.println("===================");

        int n = 10;
        memo = new String[n + 2];
        memoization(n);
        System.out.println("호출 횟수: " + cnt);
        cnt = 0;
    }

}
