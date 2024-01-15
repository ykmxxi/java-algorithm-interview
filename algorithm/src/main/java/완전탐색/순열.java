package 완전탐색;

/*
https://www.acmicpc.net/problem/15649

- N, M 주어졌을 때 조건을 만족하는 길이가 M인 수열 구하기
- 1부터 N까지 자연수 중에서 중복 없이 M 개를 고른 수열
- 1 <= M <= N <= 8
- 수열은 사전 순으로 증가하는 순서로 출력
 */

import java.util.*;
import java.io.*;

public class 순열 {

    static int n, m;
    static int[] arr, used;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        used = new int[n + 1];
    }

    static void rec_func(int depth) {
        if (depth == m) {
            for (int a : arr) {
                sb.append(a).append(' ');
            }
            sb.append('\n');
        } else {
            for (int cand = 1; cand <= n; cand++) {
                if (used[cand] == 1) {
                    continue;
                }
                arr[depth] = cand;
                used[cand] = 1; // 사용 처리

                rec_func(depth + 1);

                arr[depth] = 0;
                used[cand] = 0; // 사용이 끝나면 초기화
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        rec_func(0);

        System.out.print(sb.toString());
    }
}
