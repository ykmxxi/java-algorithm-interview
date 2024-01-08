package chap2;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

    static int[] prime; // 0 이면 소수, 1 이면 소수X

    public static void main(String[] args) {
        getPrime(1000);
    }

    // 1 부터 n 까지의 숫자 중 소수
    static void getPrime(int n) {
        prime = new int[n + 1];

        prime[0] = prime[1] = 1; // 0, 1은 소수가 아님
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i] == 0) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = 1;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i] == 0) {
                primes.add(i);
            }
        }

        System.out.println(primes);
        System.out.println("1 부터 " + n + "까지의 수 중 소수의 개수: " + primes.size());
    }

}
