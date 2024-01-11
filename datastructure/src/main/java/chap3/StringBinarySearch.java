package chap3;

import java.util.Arrays;

public class StringBinarySearch {

    public static void main(String[] args) {
        String[] arr = {
                "a", "d", "b", "z", "f", "k", "m", "e", "l", "w", "c"
        };

        Arrays.sort(arr); // 자연 정렬이 된 배열은 바로 정렬 기능 이용 가능
        int b = Arrays.binarySearch(arr, "b");
        if (b < 0) {
            System.out.println("존재하지 않음");
        }
        System.out.println("b = " + b);
    }

}
