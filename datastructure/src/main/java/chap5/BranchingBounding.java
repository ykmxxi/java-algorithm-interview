package chap5;

// 분기 한정법: 모든 조합을 나열하고 조건을 통해 필요하지 않은 분기를 없애기
public class BranchingBounding {

    static boolean[] flag = new boolean[8]; // 각 행에 퀸을 배치했는지 체크
    static int[] pos = new int[8]; // 각 열에 있는 퀸의 위치, pos[3] = 2 -> 3열의 퀸은 2행에 위치
    static int cnt1 = 0; // 규칙 1 적용
    static int cnt2 = 0; // 규칙 1, 규칙 2 적용

    static void set1(int col) {
        for (int row = 0; row < 8; row++) {
            pos[col] = row;
            if (col == 7) {
                cnt1++;
            } else {
                set1(col + 1);
            }
        }
    }


    // col 열의 알맞은 위치에 퀸을 배치
    static void set2(int col) {
        for (int row = 0; row < 8; row++) {
            if (flag[row]) { // row 행에 퀸이 이미 배치되어 있으면
                continue;
            }
            pos[col] = row; // col 열의 row 행에 퀸을 배치

            if (col == 7) { // 모든 열에 퀸을 배치했으면
                cnt2++;
            } else { // row 행에 퀸을 배치 했으면
                flag[row] = true;
                set2(col + 1);
                flag[row] = false; // 초기화
            }

        }
    }

    public static void main(String[] args) {
        set1(0);
        System.out.println("규칙 1: 각 열에 퀸을 1개만 배치");
        System.out.println("규칙 1 적용 경우의 수: " + cnt1); // 16777216

        pos = new int[8];
        set2(0);
        System.out.println("규칙 1: 각 열에 퀸을 1개만 배치");
        System.out.println("규칙 2: 각 행에 퀸을 1개만 배치");
        System.out.println("규칙 1, 규칙 2 적용 경우의 수: " + cnt2); // 40320

    }

}
