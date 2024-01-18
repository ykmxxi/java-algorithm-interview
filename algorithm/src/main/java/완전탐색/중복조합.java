package 완전탐색;

/*
    - 1 ~ N 자연수 중 M개를 고른 수열
    - 같은 수를 여러 번 골라도 된다
    - 고른 수열은 비내림차순
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
    }

    static void rec(int depth) {
        if (depth == M) { // M 개를 다 골랐으면
            for (int a : arr) {
                sb.append(a).append(' ');
            }
            sb.append('\n');
            return;
        }
        int start;
        if (depth == 0) {
            start = 1;
        } else {
            start = arr[depth - 1];
        }
        for (int cand = start; cand <= N; cand++) {
            arr[depth] = cand;
            rec(depth + 1);
            arr[depth] = 0;
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        rec(0);
        System.out.print(sb.toString());
    }

}
