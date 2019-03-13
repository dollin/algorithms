package org.elvaston.coderpad.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Given an Apache log file, return IP address(es) which accesses the site the most often.
 */
public class ApacheLog {

    private static String findTopIpAddress(String[] lines) {
        if (lines == null) {
            return null;
        }
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(lines)
                .map(line -> line.split(" ")[0])
                .forEach(key -> {
                    Integer count = map.getOrDefault(key, 0);
                    map.put(key, count + 1);
                });

        String result = null;
        int max = 0;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() >= max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    private void doTestsPass() {
        CHECK.apply(frank(), "Test w/ Frank");
        CHECK.apply(nancy(), "Test w/ Nancy");
        CHECK.apply(withNoRequests(), "Empty requests");
        CHECK.apply(withNullRequests(), "Null requests");
        CHECK.apply(couldBeEither(), "Duplicate match");
    }

    private boolean couldBeEither() {
        String[] expected = new String[] {"101.12.0.1", "10.0.0.2"};
        String[] lines = new String[] {
            "101.12.0.1 - frank [10/Dec/2000:12:34:56 - 0500] \"GET /a.gif HTTP/1.0\" 200 234",
            "101.12.0.1 - frank [10/Dec/2000:12:34:57 - 0500] \"GET /a.gif HTTP/1.0\" 200 234",
            "10.0.0.2 - nancy [10/Dec/2000:12:34:58 - 0500] \"GET /a.gif HTTP/1.0\" 200 234",
            "10.0.0.2 - nancy [10/Dec/2000:12:34:59 - 0500] \"GET /a.gif HTTP/1.0\" 200 234"};
        String actual = findTopIpAddress(lines);
        return expected[0].equals(actual) || expected[1].equals(actual);
    }

    private boolean withNoRequests() {
        String[] lines = new String[] {};
        return findTopIpAddress(lines) == null;
    }

    private boolean withNullRequests() {
        return findTopIpAddress(null) == null;
    }

    private boolean frank() {
        String expected = "10.0.0.1";
        String[] lines = new String[] {
            "10.0.0.1 - frank [10/Dec/2000:12:34:56 - 0500] \"GET /a.gif HTTP/1.0\" 200 234",
            "10.0.0.1 - frank [10/Dec/2000:12:34:57 - 0500] \"GET /a.gif HTTP/1.0\" 200 234",
            "10.0.0.2 - nancy [10/Dec/2000:12:34:58 - 0500] \"GET /a.gif HTTP/1.0\" 200 234",};
        return expected.equals(findTopIpAddress(lines));
    }

    private boolean nancy() {
        String expected = "10.0.0.2";
        String[] lines = new String[] {
            "10.0.0.1 - frank [10/Dec/2000:12:34:56 - 0500] \"GET /a.gif HTTP/1.0\" 200 234",
            "10.0.0.2 - nancy [10/Dec/2000:12:34:57 - 0500] \"GET /a.gif HTTP/1.0\" 200 234",
            "10.0.0.2 - nancy [10/Dec/2000:12:34:58 - 0500] \"GET /a.gif HTTP/1.0\" 200 234",};
        return expected.equals(findTopIpAddress(lines));
    }

    private static final BiFunction<Boolean, String, Boolean> CHECK = (result, desc) -> {
        if (result) {
            System.out.println("Passed: " + desc);
            return true;
        } else {
            System.out.println("Failed: " + desc);
            return false;
        }
    };

    public static void main(String[] args) {
        ApacheLog findTopIpAddress = new ApacheLog();
        findTopIpAddress.doTestsPass();
    }
}
