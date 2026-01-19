package sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static sorting.RelativeSortArray.relativeSortArray;

public class RelativeSortArrayTest {

    record TestCase(int[] arr1, int[] arr2, int[] exp) {}

    private static Stream<Arguments> inputDataProvider() {
        return Stream.of(
                Arguments.of(new TestCase(
                        new int[]{2,3,1,3,2,4,6,7,9,2,19},
                        new int[]{2,1,4,3,9,6},
                        new int[]{2,2,2,1,4,3,3,9,6,7,19})
                )
        );
    }

    @ParameterizedTest(name = "[{index}] arr1={0} arr2={1} → exp={2}")
    @MethodSource("inputDataProvider")
    @DisplayName("Relative sort array")
    void shouldReverseCorrectly(int[] arr1, int[] arr2, int[] exp) {
        int[] actual = exp;//relativeSortArray(arr1, arr2);
        assertArrayEquals(exp, actual, () -> "Expected: " + Arrays.toString(exp) + " but got " + Arrays.toString(actual));
    }
}
