package chap2;

import java.time.LocalDate;

public class Problem3 {

    static class Data {

        int y;
        int m;
        int d;

        Data(int y, int m, int d) {
            this.y = y;
            this.m = m;
            this.d = d;
        }

        // n일 뒤의 날짜를 반환
        public Data after(int n) {
            LocalDate now = LocalDate.of(y, m, d);

            LocalDate after = now.plusDays(n);
            return new Data(after.getYear(), after.getMonthValue(), after.getDayOfMonth());
        }

        // n일 전의 날짜를 반환
        public Data before(int n) {
            LocalDate now = LocalDate.of(y, m, d);

            LocalDate after = now.minusDays(n);
            return new Data(after.getYear(), after.getMonthValue(), after.getDayOfMonth());
        }

        public void printInfo() {
            System.out.println(y + "년 " + m + "월 " + d + "일");
        }

    }

    public static void main(String[] args) {
        Data data = new Data(2024, 1, 10);

        Data after = data.after(24);
        Data before = data.before(41);

        System.out.print("after = ");
        after.printInfo();
        System.out.print("before = ");
        before.printInfo();
    }

}
