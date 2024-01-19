package 문자열처리;

/*
- https://leetcode.com/problems/valid-palindrome/

 */
public class Leet125 {

    // 풀이1: 문자 단위로 추출해서 처리
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) { // 서로 중앙으로 이동해 겹치면 종료
            if (!Character.isLetterOrDigit(s.charAt(start))) { // 영숫자가 아니면 start 한 칸 이동
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) { // 영숫자가 아니면 end 한 칸 이동
                end--;
            } else {
                // 하나라도 다르면 회문이 아님
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    // 풀이2: 문자열 직접 비교
    public boolean isPalindrome2(String s) {
        // 정규식으로 유효한 문자만 놔두고 나머지는 제거한 후 소문자로 변경
        String str = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        return str.equals(new StringBuilder(str).reverse().toString());
    }

}
