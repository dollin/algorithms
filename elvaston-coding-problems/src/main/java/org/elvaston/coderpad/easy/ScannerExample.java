package org.elvaston.coderpad.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class ScannerExample {

    public static void main(String... args) {
//        Scanner scanner = new Scanner(System.in);
//        int k = scanner.nextInt();
//        String line = scanner.nextLine();

        String s = ", 3 out of 4 times. This is line 3? Yes.!";
        int k = 3;
        String line = " 2, 2, 3333, 4, 1 ,44, 9999";
        System.out.println(k + "= " + line);
        System.out.println(line + " :kth smallest is: " + kthSmallest(k, line));
        line = "2, 2, 2, 2";
        System.out.println(line + " :kth smallest is: " + kthSmallest(k, line));

    }

    private static int kthSmallest(int k, String line) {
        String[] numbersStrings = line.split(",");
        Integer[] numbers = new Integer[numbersStrings.length];
        for (int j = 0; j < numbers.length; j++) {
            numbers[j] = Integer.valueOf(numbersStrings[j].trim());
        }

        int kthSmallest = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            int smallest = Integer.MAX_VALUE;
            for (Integer number : numbers) {
                if (number < smallest) {
                    smallest = number;
                }
            }

            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] == smallest) {
                    numbers[j] = Integer.MAX_VALUE;
                }
            }
            kthSmallest = smallest;

            System.out.println(" smallest: " + smallest);
        }

        return kthSmallest == Integer.MAX_VALUE ? -1 : kthSmallest;
//        List<Integer> l = Arrays.stream(numbers)
//                .mapToInt(value -> Integer.valueOf(value.trim()))
//                .boxed()
//                .sorted()
//                .collect(Collectors.toList());
//        Set<Integer> s = new HashSet<>();
//
//        s.addAll(l);
//        System.out.println(l);
//        System.out.println(s);
//        return s.size() >= k ? (int) s.toArray()[k - 1] : -1;

//        if (k >= l.size()) {
//            return -1;
//        }
//        int kthCount = 0;
//        int kthSmallest = -1;
//        for (Integer i: l) {
//            if (kthCount < k && i > kthSmallest) {
//                kthSmallest = i;
//                kthCount++;
//            }
//        }
//        System.out.println(l);
//        return kthCount == k ? kthSmallest : -1;
    }

}
