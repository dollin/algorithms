package org.elvaston.coderpad.easy;


public class RunLengthEncoding {

    /**
     * Implement rle so the tests pass.
     */
    private static String rle(String input) {
        StringBuilder returnString = new StringBuilder("");
        Character current = null;
        int count = 1;
        for (char c: input.toCharArray()) {
            if (current != null && current == c) {
                count++;
            } else {
                if (current != null) {
                    returnString.append(current).append(count);
                }
                count = 1;
                current = c;
            }
        }
        if (current != null) {
            returnString.append(current).append(count);
        }
        return returnString.toString();
    }

    private static boolean doTestsPass() {
        boolean result = true;
        result = result && "a3".equals(rle("aaa"));
        result = result && "a2b3".equals(rle("aabbb"));
        result = result && "a2b3a2".equals(rle("aabbbaa"));
        result = result && "a1".equals(rle("a"));

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
