package org.elvaston.coderpad.easy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;

/**
 * Given two fractions passed in as int arrays return the fraction which is the result
 * of adding the two fractions together.
 * The fraction is represented as a two-element array {numerator, denominator}
 */
public class AddFractions {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Test {
    }

    private static int[] addFractions(int[] fractionA, int[] fractionB) {
        if (fractionA == null || fractionA.length == 0) {
            return fractionB;
        }
        if (fractionB == null || fractionB.length == 0) {
            return fractionA;
        }
        if (fractionA[1] == fractionB[1]) {
            return new int[]{fractionA[0] + fractionB[0], fractionA[1]};
        }
        int denominator = fractionA[1] * fractionB[1];
        int numerator = (fractionA[0] * denominator / fractionA[1]) + (fractionB[0] * denominator / fractionB[1]);
        return reduce(denominator, numerator);
    }

    private static int[] reduce(int denominator, int numerator) {
        int divisor = IntStream.rangeClosed(1, Math.min(denominator, numerator))
                .filter(value -> denominator % value == 0 && numerator % value == 0)
                .max().orElse(1);
        return new int[]{numerator / divisor, denominator / divisor};
    }

    @Test
    public void improperFraction() {
        CHECK.accept("7/6", addFractions(new int[]{4, 6}, new int[]{3, 6}));
    }

    @Test
    public void improperFractionWithDifferentDenominators() {
        CHECK.accept("7/6", addFractions(new int[]{2, 3}, new int[]{1, 2}));
    }

    @Test
    public void improperFraction1() {
        CHECK.accept("3/2", addFractions(new int[]{1, 1}, new int[]{1, 2}));
    }

    @Test
    public void addingEmptyFractions() {
        CHECK.accept("1/2", addFractions(new int[]{}, new int[]{1, 2}));
        CHECK.accept("2/3", addFractions(new int[]{2, 3}, new int[]{}));
    }

    @Test
    public void addingNullFractions() {
        CHECK.accept("1/2", addFractions(null, new int[]{1, 2}));
        CHECK.accept("2/3", addFractions(new int[]{2, 3}, null));
    }

    @Test
    public void largeFractions() {
        CHECK.accept("13/1", addFractions(new int[]{12, 6}, new int[]{132, 12}));
    }

    @Test
    public void largeFractions1() {
        CHECK.accept("11/5", addFractions(new int[]{10, 5}, new int[]{3, 15}));
    }

    private static final BiConsumer<String, int[]> CHECK = (expected, actual) -> {
        if (!expected.equals(actual[0] + "/" + actual[1])) {
            System.err.println(String.format(
                    "Test failed --> actual:%s/%s != expected:%s",
                    actual[0],
                    actual[1],
                    expected));
        }
    };

    private void executeTests() {
        Arrays.stream(AddFractions.class.getDeclaredMethods())
                .filter(method -> null != method.getAnnotation(Test.class))
                .forEach(method -> {
                    try {
                        System.err.println("Test running -> " + method.getName());
                        method.invoke(new AddFractions());
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        System.err.println(String.format(
                                "failed to invoke %s with exception %s",
                                method.getName(),
                                e));
                    }
                });
    }

    public static void main(String[] args) {
        AddFractions addFractions = new AddFractions();
        addFractions.executeTests();
    }
}