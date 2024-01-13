package chap4.stack;

public class StringStackMain {

    public static void main(String[] args) {
        ObjectStack<String> stack = new ObjectStack<>(10);

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        stack.push("g");
        stack.push("h");
        stack.push("i");
        stack.push("j");

        System.out.println("스택이 가득 차있나? " + stack.isFull());

        System.out.println("top = " + stack.peek());
        stack.dump();
        System.out.println("pop = " + stack.pop());
        System.out.println("pop = " + stack.pop());
        System.out.println("push = " + stack.push("z"));
        System.out.println("0은 어디에 존재? " + stack.indexOf("z"));
        stack.dump();

        System.out.println("capacity = " + stack.getCapacity());
        System.out.println("size = " + stack.size());

        stack.clear();
        System.out.println("스택이 비어있나? " + stack.isEmpty());
    }

}
