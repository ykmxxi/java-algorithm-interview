/*

- 암호는 서로 다른 L개의 알파벳 소문자들로 구성, 최소 한 개의 모음(a, e, i, o, u))과 최소 두 개의 자음으로 구성
- 정렬된 문자열을 선호, 알파벳이 암호에서 증가하는 순서로 배열
- 암호로 사용했을 법한 문자의 종류: C가지
- C개의 문자가 주어졌을 때 가능성 있는 암호들을 모두 구하기

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int L, C;
    static int[] sel;
    static String[] arr;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        arr = new String[C];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = st.nextToken();
        }
    }

    static void rec(int depth) {
        if (depth == L) {
            int cnt1 = 0;
            int cnt2 = 0;

            for (int i = 0; i < L; i++) {
                if (isVowels(arr[sel[i]])) {
                    cnt1++;
                } else {
                    cnt2++;
                }
            }

            if (cnt1 >= 1 && cnt2 >= 2) {
                for (int i = 0; i < L; i++) {
                    sb.append(arr[sel[i]]);
                }
                sb.append('\n');
            }
        } else {
            int start;
            if (depth == 0) {
                start = 0;
            } else {
                start = sel[depth - 1] + 1;
            }
            for (int i = start; i < arr.length; i++) {
                sel[depth] = i;
                rec(depth + 1);
                sel[depth] = 0;
            }
        }
    }

    static boolean isVowels(String str) {
        return str.equals("a") || str.equals("e") || str.equals("i") || str.equals("o") || str.equals("u");
    }

    static void pro() {
        Arrays.sort(arr); // 사전순 정렬
        sel = new int[L];
        rec(0);
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

}
