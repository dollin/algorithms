package org.elvaston.coderpad.medium;

/**
 * Takes a string and returns the int value represented by the string. For example, atoi("42") returns 42.
 */
public class Atoi {

    private static int atoi(String str) {
        int result = 0;
        int multiple = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            char charToCheck = str.charAt(i);
            if (charToCheck >= '0' && charToCheck <= '9') {
                result += ((charToCheck - '0') * multiple);
            } else if (i == 0 && charToCheck == '-') {
                result = result * -1;
            } else {
                return -1;
            }
            multiple *= 10;
        }
        return result;
    }

    private boolean doTestsPass() {
        boolean result = true;
        result &= assertConversion(3, "3");
        result &= assertConversion(12345, "12345");
        result &= assertConversion(-1, "three");
        result &= assertConversion(-1, "123456as");
        result &= assertConversion(Integer.MAX_VALUE, "2147483647");
        result &= assertConversion(-3432, "-3432");
        result &= assertConversion(Integer.MIN_VALUE, "-2147483648");
        return result;
    }

    private boolean assertConversion(int expected, String number) {
        int actual = atoi(number);
        if (expected != actual) {
            System.err.println(String.format("Failed to convert %s into %s. Returned %s",
                    number,
                    expected,
                    actual));
            return false;
        }
        return true;
    }

    /**
     * Main entry to run the coderpad.
     * @param args not used
     */
    public static void main(String[] args) {
        Atoi stringToInteger = new Atoi();

        if (stringToInteger.doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.err.println("There are test failures");
        }
    }
}
