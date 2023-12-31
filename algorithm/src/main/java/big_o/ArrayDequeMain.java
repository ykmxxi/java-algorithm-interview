package big_o;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ArrayDequeMain {

    public static void main(String[] args) {
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        Deque<Integer> linkedListDeque = new LinkedList<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 50_000_000; i++) {
            arrayDeque.offer(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayDeque 삽입 시간 : " + (end - start) + "ms"); // 1664

        start = System.currentTimeMillis();
        for (int i = 0; i < 50_000_000; i++) {
            linkedListDeque.offer(i);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList 삽입 시간 : " + (end - start) + "ms"); // 6259

        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            arrayDeque.poll();
        }
        end = System.currentTimeMillis();
        System.out.println("ArrayDeque 추출 시간 : " + (end - start) + "ms"); // 32

        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            linkedListDeque.poll();
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList 추출 시간 : " + (end - start) + "ms"); // 117

        Deque<Object> deque = new ArrayDeque<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        deque.offer(4);

        System.out.println(deque.poll()); // 가장 먼저 삽입된 1을 추출
        System.out.println(deque); // [2, 3, 4] 만 남아 있음
        System.out.println(deque.peek()); // peek() == peekFirst(), 그 다음 요소인 2를 조회
        System.out.println(deque.pollLast()); // 마지막 요소인 4을 추출
    }

}
