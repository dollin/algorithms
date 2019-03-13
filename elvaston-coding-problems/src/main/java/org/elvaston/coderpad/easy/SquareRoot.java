package org.elvaston.coderpad.easy;

public class SquareRoot {

    /**
     * Approach: -
     * Make an initial guess.
     * New E = Current E - ( F(Current E) / F'(Current E) ), where
     * F(E) = E * E - N
     * F'(E) = 2 * E
     * Repeat until you are close enough
     */
    private static double squareRoot(double input) throws IllegalArgumentException {
        if (input < 0) {
            throw new IllegalArgumentException("Invalid input " + input);
        }
        double currentEst = input / 2;
        double newEst = input;
        while (Math.abs(newEst - currentEst) > 0.000001) {
            currentEst = newEst;
            newEst = currentEst - (currentEst * currentEst - input) / (2 * currentEst);
        }
        return newEst;
    }

    private static boolean doTestsPass() {
        double[] inputs = {2, 4, 100, 50};
        double[] expected = {1.41421, 2, 10, 7.071067};
        double threshold = 0.001;
        for (int i = 0; i < inputs.length; i++) {
            double actual = squareRoot(inputs[i]);
            if (Math.abs(actual - expected[i]) > threshold) {
                System.out.println("Test failed as " + expected[i] + " != " + actual);
                return false;
            }
        }
        System.out.println("Test passed.");
        return true;
    }

    private static void negativeThrowsException() {
        try {
            squareRoot(-100);
            System.out.println("Test failed w/ -ve number");
        } catch (IllegalArgumentException e) {
            System.out.println("Test passed.");
        }
    }

    public static void main(String[] args) {
        doTestsPass();
        negativeThrowsException();
    }
}
