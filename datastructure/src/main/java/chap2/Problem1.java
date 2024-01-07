package chap2;

import java.util.Random;

public class Problem1 {

    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("키의 최대값을 구합니다.");

        int cnt = 10 + rand.nextInt(11);
        int[] height = new int[cnt];

        System.out.println("사람들의 키");
        for (int i = 0; i < height.length; i++) {
            height[i] = 100 + rand.nextInt(90);
            System.out.println((i + 1) + "번째 사람의 키: " + height[i] + "cm");
        }

        System.out.println("가장 큰 사람의 키는 " + maxOf(height) + "cm 입니다.");
    }

    static int maxOf(int[] arr) {
        int max = arr[0];
        for (int n : arr) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

}
