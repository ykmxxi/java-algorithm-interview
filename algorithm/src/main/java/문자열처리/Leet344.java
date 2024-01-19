package 문자열처리;

/*
https://leetcode.com/problems/reverse-string/description/

- 문자열을 뒤집는 함수, return 없이 배열 내부를 조작한다
- 단, O(1) 추가 메모리를 사용하여 입력 배열을 내부에서 수정하여 이를 수행해야 한다
 */
public class Leet344 {

    public void reverseString(char[] s) {
        int L = 0;
        int R = s.length - 1;

        while (L < R) {
            char tmp = s[L];
            s[L] = s[R];
            s[R] = tmp;

            L++;
            R--;
        }
    }

}
