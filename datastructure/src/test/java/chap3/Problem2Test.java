package chap3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Problem2Test {

    @Test
    void test() {
        int[] arr = {1, 3, 5, 7, 7, 7, 7, 8, 8, 9, 9};

        assertThat(Problem2.binSearchX(arr, 7)).isEqualTo(3);
        assertThat(Problem2.binSearchX(arr, 8)).isEqualTo(7);
        assertThat(Problem2.binSearchX(arr, 9)).isEqualTo(9);
        assertThat(Problem2.binSearchX(arr, 2)).isEqualTo(-1);

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(Arrays.binarySearch(arr1, 4)).isEqualTo(3);
        assertThat(Arrays.binarySearch(arr1, 10)).isEqualTo(-10);
    }

}
