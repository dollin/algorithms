package org.elvaston.sort;

import org.elvaston.api.Sort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

/**
 * Selection Sort.
 * One of the simplest sorting algorithms that works as follows:
 * First, find the smallest item in the array, and exchange it with the first entry. Then, find the next smallest
 * item and exchange it with the second entry. Continue in this way until the entire array is sorted.
 * This method is called selection sort because it works by repeatedly selecting the smallest remaining item.
 *
 * Proposition: Selection sort uses ~(N^2)/2 compares and n exchanges to sort an array of length N.
 */
public class SelectionSort implements Sort {

    private static final Logger LOG = LoggerFactory.getLogger(SelectionSort.class);

    @Override
    public void sort(char[] chars) {
        LOG.info("{}", chars);

        IntStream.range(0, chars.length).forEach(i -> {
            char min = Character.MAX_VALUE;
            int to = i;
            for (int j = i; j < chars.length; j++) {
                if (chars[j] < chars[i] && chars[j] < min) {
                    to = j;
                    min = chars[j];
                }
            }
            logSwitches(chars, i, to);
            swap(chars, i, to);
        });
        LOG.info("{}", chars);
    }
}
