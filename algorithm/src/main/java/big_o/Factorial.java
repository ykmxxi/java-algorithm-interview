package big_o;

public class Factorial {

    public static int count = 0;

    public static void printInfo(int n) {
        System.out.println("n! = " + factorial(n));
        System.out.println("count = " + count);
    }

    public static int factorial(int n) {
        if (n >= 1) {
            count++;
            return n * factorial(n - 1);
        }
        count++;
        return 1;
    }

}
