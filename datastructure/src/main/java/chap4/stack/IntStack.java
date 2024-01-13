package chap4.stack;

public class IntStack {

    private int[] stack; // 스택 저장 배열
    private int capacity; // 스택 용량
    private int pointer; // 스택 인덱스

    // 런타임 예외: 스택이 비어 있음
    public static class EmptyIntStackException extends RuntimeException {

        public EmptyIntStackException() {
        }

    }

    // 런타임 예외: 스택이 가득 차있음
    public static class OverflowIntStackException extends RuntimeException {

        public OverflowIntStackException() {
        }

    }

    public IntStack(int maxLength) {
        pointer = 0;
        capacity = maxLength;
        try {
            stack = new int[capacity];
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
            capacity = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException {
        if (pointer >= capacity) {
            throw new OverflowIntStackException();
        }
        return stack[pointer++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if (pointer <= 0) {
            throw new EmptyIntStackException();
        }
        return stack[--pointer];
    }

    public int peek() throws EmptyIntStackException {
        if (pointer <= 0) {
            throw new EmptyIntStackException();
        }
        return stack[pointer - 1];
    }

    public void clear() {
        pointer = 0;
    }

    // 스택에서 x를 찾아 인덱스를 반환, 없으면 -1
    public int indexOf(int x) {
        for (int i = pointer - 1; i >= 0; i--) {
            if (stack[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // 스택의 용량 반환
    public int getCapacity() {
        return capacity;
    }

    // 스택에 쌓여 있는 데이터의 개수를 반환
    public int size() {
        return pointer;
    }

    public boolean isEmpty() {
        return pointer <= 0;
    }

    public boolean isFull() {
        return pointer >= capacity;
    }

    // 스택의 데이터를 바닥(bottom) -> 꼭대기(top) 순서로 출력
    public void dump() throws EmptyIntStackException {
        if (pointer <= 0) {
            throw new EmptyIntStackException();
        }
        for (int i = 0; i < pointer; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

}
