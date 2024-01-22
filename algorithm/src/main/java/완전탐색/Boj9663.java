package 완전탐색;

/*
    https://www.acmicpc.net/problem/9663
    - N x N 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 방법의 수를 구하는 문제
    - 1 <= N < 15
 */

import java.util.*;
import java.io.*;

public class Boj9663 {

    static int[] pos;
    static int ans, N;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        pos = new int[N + 1];
        ans = 0;
    }

    static void rec(int row) {
        if (row == N + 1) {
            ans++;
        } else {
            for (int col = 1; col <= N; col++) {
                boolean flag = true;

                for (int i = 1; i <= row - 1; i++) {
                    if (canAttack(row, col, i, pos[i])) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    pos[row] = col;
                    rec(row + 1);
                    pos[row] = 0;
                }
            }
        }
    }

    static boolean canAttack(int row1, int col1, int row2, int col2) {
        if (col1 == col2) {
            return true;
        }
        if (row1 - col1 == row2 - col2) {
            return true;
        }
        if (row1 + col1 == row2 + col2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        input();
        rec(1);
        System.out.println(ans);
    }

}
