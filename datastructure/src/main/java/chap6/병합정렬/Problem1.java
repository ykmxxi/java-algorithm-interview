package chap6.병합정렬;

import java.util.Arrays;

public class Problem1 {

    static class Data implements Comparable<Data> {

        String name;
        long height;
        double vision;

        public Data(final String name, final int height, final double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public int compareTo(Data o) {
            if (this.vision != o.vision) {
                return Double.compare(o.vision, this.vision); // 시력 내림차순
            }
            return Long.compare(this.height, o.height); // 키 오름차순
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    ", vision=" + vision +
                    '}';
        }

    }

    public static void main(String[] args) {
        Data[] arr = {
                new Data("A", 162, 0.3),
                new Data("B", 173, 1.3),
                new Data("BB", 172, 1.3),
                new Data("C", 175, 0.4),
                new Data("D", 181, 0.5),
                new Data("E", 161, 0.9),
                new Data("F", 166, 1.0),
                new Data("G", 185, 1.1),
        };

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
