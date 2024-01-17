package chap5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class EuclideanTest {

    @Test
    void test() {
        assertThat(Euclidean.gcd(22, 8)).isEqualTo(2);
        assertThat(Euclidean.gcd(192, 162)).isEqualTo(6);
        assertThat(Euclidean.lcm(11, 8)).isEqualTo(88);

    }

}
