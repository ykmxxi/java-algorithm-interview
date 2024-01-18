package 완전탐색;

/*
    https://www.acmicpc.net/problem/14888

    - N개의 수열로 이루어진 수열 A1 ~ An, 수와 수 사이에 끼어넣는 N - 1개의 연산자
    - 연산자는 덧셈, 뺄셈, 곱셈, 나눗셈
    - 수와 수 사이에 연산자를 넣어 수식을 만들 수 있다. 이때 주어진 수의 순서를 바꿀 수 없음
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14888 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, max, min;
    static int[] arr, oprs;

    static void input() {
        try {
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            oprs = new int[4]; // 0(덧셈), 1(뺄셈), 2(곱셈), 3(나눗셈)
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 4; i++) {
                oprs[i] = Integer.parseInt(st.nextToken());
            }

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
        } catch (IOException e) {
        }
    }

    static void rec(int depth, int value) {
        if (depth == N - 1) {
            max = Math.max(value, max);
            min = Math.min(value, min);
            return;
        }
        for (int cand = 0; cand < 4; cand++) {
            if (oprs[cand] >= 1) {
                oprs[cand]--;
                rec(depth + 1, calc(value, cand, arr[depth + 1]));
                oprs[cand]++;
            }
        }
    }

    static int calc(int a, int opr, int b) {
        if (opr == 0) {
            return a + b;
        }
        if (opr == 1) {
            return a - b;
        }
        if (opr == 2) {
            return a * b;
        }
        return a / b;
    }

    public static void main(String[] args) {
        input();
        rec(0, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

}
