package org.elvaston.coderpad.easy;

public class Fibonacci {

    /**
     * must have O(n) runtime and O(1) memory.
     */
    public static int fibonacci(int input) {
        if (input < 2) {
            return input;
        } else if (input == 2) {
            return 1;
        }
        int fib = 1;
        int fibLast = 1;

        for (int i = 3; i <= input; i++) {
            int temp = fib;
            fib += fibLast;
            fibLast = temp;
        }
        return fib;
    }

    private static boolean doTestsPass() {
        boolean result = true;
        result = result && fibonacci(0) == 0;
        result = result && fibonacci(1) == 1;
        result = result && fibonacci(2) == 1;
        result = result && fibonacci(10) == 55;
        result = result && fibonacci(40) == 102334155;
        if (result) {
            System.out.println("Test passed.");
            return true;
        } else {
            System.out.println("Test failed.");
            return false;
        }
    }

    public static void main(String[] args) {
        doTestsPass();
    }
}
