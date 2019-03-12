package org.elvaston.coderpad.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Returns an array containing prime numbers whose product is x.
 */
public class PrimeFactorization {

    private static ArrayList<Integer> primeFactorization(int factorsOf) {
        ArrayList<Integer> factors = new ArrayList<>();

        for (int factor = 2; factor <= factorsOf; ) {
            if (factorsOf % factor == 0) {
                factors.add(factor);
                factorsOf /= factor;
            } else {
                factor++;
            }
        }
        return factors;
    }

    private static boolean doTestsPass() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(2, 3)));
        expected.add(new ArrayList<>(Arrays.asList(2, 2, 3)));
        expected.add(new ArrayList<>(Arrays.asList(2, 5)));
        expected.add(new ArrayList<>(Arrays.asList(3, 3)));

        List<List<Integer>> results = new ArrayList<>();
        results.add(primeFactorization(6));
        results.add(primeFactorization(12));
        results.add(primeFactorization(10));
        results.add(primeFactorization(9));

        for (int i = 0; i < expected.size(); i++) {
            if (expected.get(i).equals(results.get(i))) {
                System.out.println(expected.get(i) + " == " + results.get(i));
            } else {
                System.out.println("Test failed for index: " + i + ", " + expected.get(i) + " != " + results.get(i));
                return false;
            }
        }

        System.out.println("All tests passed");
        return true;
    }

    public static void main(String[] args) {
        doTestsPass();
    }
}