package chap3;

import java.util.Arrays;
import java.util.Comparator;

public class PersonBinarySearch {

    static class Person {

        String name;
        double height;

        public Person(final String name, final double height) {
            this.name = name;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    '}';
        }

    }

    public static void main(String[] args) {
        Person[] persons = {new Person("a", 172.3),
                new Person("b", 183.3),
                new Person("c", 161.6),
                new Person("d", 172.6),
                new Person("e", 179.1),
                new Person("f", 162.3),
                new Person("g", 191.9)};

        Arrays.sort(persons, Comparator.comparingDouble(o -> o.height)); // 오름차순 정렬
        for (Person person : persons) {
            System.out.println(person);
        }
        System.out.println(
                Arrays.binarySearch(persons, new Person("", 161.6), Comparator.comparingDouble(o -> o.height)));
        System.out.println("==================");
        Arrays.sort(persons, (o1, o2) -> Double.compare(o2.height, o1.height)); // 내림차순 정렬
        for (Person person : persons) {
            System.out.println(person);
        }
        System.out.println(
                Arrays.binarySearch(persons, new Person("", 161.6), (o1, o2) -> Double.compare(o2.height, o1.height)));
    }

}
