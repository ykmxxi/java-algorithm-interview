package chap4.queue;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class IntQueueTest {

    @Test
    void searchTest() {
        IntQueue que = new IntQueue(12);
        que.enQueue(35);
        que.enQueue(56);
        que.enQueue(24);
        que.enQueue(68);
        que.enQueue(95);
        que.enQueue(73);
        que.enQueue(19);

        assertThat(que.search(35)).isEqualTo(1);
        assertThat(que.search(95)).isEqualTo(5);
        assertThat(que.search(73)).isEqualTo(6);
        assertThat(que.search(19)).isEqualTo(7);
        assertThat(que.search(99)).isEqualTo(0);
    }

}
