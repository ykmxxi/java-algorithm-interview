package chap3;

public class LinearSearch {

    /**
     * 보초법을 사용한 선형 검색: 검색 실패 조건을 없애 비용을 반으로 줄임
     * @param a   : 배열
     * @param n   : 요소수
     * @param key : 찾으려는 값
     */
    static int linearSearchSentinel(int[] a, int n, int key) {
        int i = 0;
        a[n] = key;

        while (true) {
            if (a[i] == key) {
                break;
            }
            i++;
        }
        return i == n ? -1 : i;
    }

}
