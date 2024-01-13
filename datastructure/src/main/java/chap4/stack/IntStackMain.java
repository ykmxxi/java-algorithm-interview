package chap4.stack;

import java.util.Random;

public class IntStackMain {

    public static void main(String[] args) {
        IntStack stack = new IntStack(10);

        Random random = new Random();
        while (!stack.isFull()) {
            int x = random.nextInt(100) + 1;
            stack.push(x);
        }

        System.out.println("스택이 가득 차있나? " + stack.isFull());

        System.out.println("top = " + stack.peek());
        stack.dump();
        System.out.println("pop = " + stack.pop());
        System.out.println("pop = " + stack.pop());
        System.out.println("push = " + stack.push(0));
        System.out.println("0은 어디에 존재? " + stack.indexOf(0));
        stack.dump();

        System.out.println("capacity = " + stack.getCapacity());
        System.out.println("size = " + stack.size());

        stack.clear();
        System.out.println("스택이 비어있나? " + stack.isEmpty());
    }

}
