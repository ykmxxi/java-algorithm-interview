package chap5;

import java.util.Scanner;

public class Hanoi {

    // no개의 원반을 x번 기둥에서 y번 기둥으로 이동
    static void move(int no, int x, int y) {
        if (no > 1) {
            // 시작 기둥의 바닥 원반을 제외한 나머지 그룹을 시작 기둥에서 중간 기둥으로 옮기기
            // 3개의 기둥 (1번, 2번, 3번) -> 기둥 번호의 합이 6이므로 시작 기둥, 목표 기둥이 어느 기둥이더라도 중간 기둥은 6 - x - y
            move(no - 1, x, 6 - x - y);
        }

        System.out.printf("원반[%d]을 %d번 기둥에서 %d번 기둥으로 옮김\n", no, x, y); // 바닥 원반을 시작 기둥에서 목표 기둥으로 옮김

        if (no > 1) {
            move(no - 1, 6 - x - y, y); // 그룹을 중간 기둥에서 목표 기둥으로 옮김
        }
    }

    static void moveWithoutRec(int no, int x, int y) {
        int[] xstk = new int[100];
        int[] ystk = new int[100];
        int[] sstk = new int[100]; // 스택
        int ptr = 0; // 스택포인터
        int sw = 0;

        while (true) {
            if (sw == 0 && no > 1) {
                xstk[ptr] = x; // x의 값을 푸시
                ystk[ptr] = y; // y의 값을 푸시
                sstk[ptr] = sw; // sw의 값을 푸시
                ptr++;
                no = no - 1;
                y = 6 - x - y;
                continue;
            }

            System.out.printf("원반[%d]을 %d 기둥에서 %d 기둥으로 이동\n", no, x, y);

            if (sw == 1 && no > 1) {
                xstk[ptr] = x; // x의 값을 푸시
                ystk[ptr] = y; // y의 값을 푸시
                sstk[ptr] = sw; // sw의 값을 푸시
                ptr++;
                no = no - 1;
                x = 6 - x - y;
                if (++sw == 2) {
                    sw = 0;
                }
                continue;
            }
            do {
                if (ptr-- == 0) { // 스택이 비어 있으면
                    return;
                }
                x = xstk[ptr]; // 값을 저장하고 있는 x를 팝
                y = ystk[ptr]; // 값을 저장하고 있는 y을 팝
                sw = sstk[ptr] + 1; // 값을 저장하고 있는 sw을 팝
                no++;
            } while (sw == 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반의 개수: ");
        int n = sc.nextInt();

        move(n, 1, 3); // 1번 기둥(시작 기둥)에 쌓인 n개의 원반을 3번 기둥으로 옮김
    }

}
