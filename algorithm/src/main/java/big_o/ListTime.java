package big_o;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTime {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long start = System.currentTimeMillis();
        addElements(arrayList);
        long end = System.currentTimeMillis();
        System.out.println("ArrayList 4천만 개 삽입 시간 : " + (end - start) + "ms"); // 1280ms

        start = System.currentTimeMillis();
        addElements(linkedList);
        end = System.currentTimeMillis();
        System.out.println("LinkedList 4천만 개 삽입 시간 : " + (end - start) + "ms"); // 5048ms

        start = System.currentTimeMillis();
        removeElement(arrayList);
        end = System.currentTimeMillis();
        System.out.println("ArrayList 10,000,000번 째 요소 100번 삭제 시간 : " + (end - start) + "ms"); // 2639ms

        start = System.currentTimeMillis();
        removeElement(linkedList);
        end = System.currentTimeMillis();
        System.out.println("LinkedList 10,000,000번 째 요소 100번 삭제 시간 : " + (end - start) + "ms"); // 8371ms
    }

    private static void addElements(final List<Integer> list) {
        for (int i = 0; i < 40_000_000; i++) {
            list.add(i);
        }
    }

    private static void removeElement(final List<Integer> list) {
        for (int i = 0; i < 100; i++) {
            list.remove(10000000);
        }
    }

}
