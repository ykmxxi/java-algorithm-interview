package chap4.queue;

public class IntQueue {

    private int[] que;
    private int capacity;
    private int num; // 현재 데이터 개수
    private int front; // 데이터가 나오는 쪽
    private int rear; // 데이터를 넣는 쪽

    static class EmptyIntQueueException extends RuntimeException {

        public EmptyIntQueueException() {
        }

    }

    static class OverflowIntQueueException extends RuntimeException {

        public OverflowIntQueueException() {
        }

    }

    public IntQueue(int capacity) {
        num = front = rear = 0;
        this.capacity = capacity;
        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
            this.capacity = 0;
        }
    }

    public int enQueue(int x) throws OverflowIntQueueException {
        if (num >= capacity) {
            throw new OverflowIntQueueException();
        }

        que[rear++] = x;
        num++;

        if (rear == capacity) { // 다음 요소를 추가할 위치인 rear가 capacity와 같아지면 0으로 초기화
            rear = 0;
        }
        return x;
    }

    public int deQueue() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }

        int x = que[front++];
        num--;

        if (front == capacity) {
            front = 0;
        }
        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }
        return que[front];
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % capacity;
            if (que[idx] == x) {
                return idx;
            }
        }
        return -1;
    }

    public int search(int x) throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }
        int idx;
        for (int i = 0; i < capacity; i++) {
            if (que[i] == x) {
                if (i < front) {
                    return (i + capacity) - front + 1;
                } else {
                    return i - front + 1;
                }
            }
        }
        return 0; // 없으면 0 반환
    }

}
