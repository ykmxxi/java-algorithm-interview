package chap5;

public class Factorial {

    public static int factorial1(int n) {
        if (n > 1) {
            return n * factorial1(n - 1);
        }
        return 1;
    }

    public static int factorial2(int n) {
        return (n > 1) ? n * factorial2(n - 1) : 1;
    }

}
