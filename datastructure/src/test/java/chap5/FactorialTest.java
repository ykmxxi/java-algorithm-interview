package chap5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FactorialTest {

    @Test
    void test() {
        assertThat(Factorial.factorial1(5)).isEqualTo(120);
        assertThat(Factorial.factorial2(4)).isEqualTo(24);

        assertThat(Factorial.factorial1(1)).isEqualTo(1);
        assertThat(Factorial.factorial2(1)).isEqualTo(1);
    }

}
