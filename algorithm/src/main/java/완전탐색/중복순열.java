package 완전탐색;

/*
  https://www.acmicpc.net/problem/15651
  N과 M(3)
  - 자연수 N, M 주어졌을 때 조건을 만족하는 길이가 M인 수열을 모두 구하기
  - 1 ~ N 자연수 중 M개를 고른 수열
  - 같은 수를 여러 번 골라도 된다 -> (1 1), (2 2) 가능
  - 1 <= M <= N <= 7
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 중복순열 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;
    static int[] arr;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m + 1];
    }

    static void rec_func(int k) {
        if (k == m + 1) { // m개를 다 고른 경우
            for (int i = 1; i <= m; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int cand = 1; cand <= n; cand++) {
                arr[k] = cand;
                rec_func(k + 1);
                arr[k] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        rec_func(1);
        System.out.print(sb.toString());
    }

}
