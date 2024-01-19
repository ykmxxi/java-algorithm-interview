package chap5;

public class EightQueen {

    static boolean[] flagRow = new boolean[8]; // 각 행에 퀸을 배치했는지 체크
    static boolean[] flagA = new boolean[15]; // 우상향 대각선 퀸을 배치했는지 체크 (/)
    static boolean[] flagB = new boolean[15]; // 우하향 대각선 퀸을 배치했는지 체크 (\)
    static int[] pos = new int[8];
    static int cnt = 0;

    static void set(int col) {
        for (int row = 0; row < 8; row++) {
            if (flagRow[row] || flagA[col + row] || flagB[col - row + 7]) {
                continue;
            }

            pos[col] = row;
            if (col == 7) {
                cnt++;
            } else {
                flagRow[row] = true;
                flagA[col + row] = true;
                flagB[col - row + 7] = true;

                set(col + 1);

                flagRow[row] = false;
                flagA[col + row] = false;
                flagB[col - row + 7] = false;
            }
        }
    }

    public static void main(String[] args) {
        set(0);
        System.out.println("8-Queen 경우의 수: " + cnt); // 92
    }

}
