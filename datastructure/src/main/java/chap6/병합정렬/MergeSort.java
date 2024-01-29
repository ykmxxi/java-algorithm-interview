package chap6.병합정렬;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    static void split(List<Integer> list) {
        if (list.size() <= 1) {
            return;
        }

        int m = list.size() / 2;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        left = new ArrayList<>(list.subList(0, m));
        right = new ArrayList<>(list.subList(m, list.size()));
    }

    static List<Integer> mergeSplitFunc(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        int m = list.size() / 2;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        left = mergeSplitFunc(new ArrayList<>(list.subList(0, m)));
        right = mergeSplitFunc(new ArrayList<>(list.subList(m, list.size())));

        return merge(left, right);
    }

    static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> list = new ArrayList<>();

        int l = 0;
        int r = 0;

        while (left.size() > l && right.size() > r) {
            if (left.get(l) > right.get(r)) {
                list.add(right.get(r));
                r++;
            } else {
                list.add(left.get(l));
                l++;
            }
        }

        while (left.size() > l) {
            list.add(left.get(l));
            l++;
        }

        while (right.size() > r) {
            list.add(right.get(r));
            r++;
        }

        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int index = 0; index < 20; index++) {
            list.add((int) (Math.random() * 100));
        }
        System.out.println(list);
        System.out.println(mergeSplitFunc(list));
    }

}
