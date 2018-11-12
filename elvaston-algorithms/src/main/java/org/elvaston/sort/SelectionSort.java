package org.elvaston.sort;

import org.elvaston.api.Sort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SelectionSort.
 * One of the simplest sorting algorithms that works as follows:
 * First, find the smallest item in the array, and exchange it with the first entry. Then, find the next smallest
 * item and exchange it with the second entry. Continue in this way until the entire array is sorted.
 * This method is called selection sort because it works by repeatedly selecting the smallest remaining item.
 * <p>
 * Proposition: Selection sort uses ~(N^2)/2 compares and n exchanges to sort an array of length N.
 * </p>
 */
public class SelectionSort implements Sort {

    private static final Logger LOG = LoggerFactory.getLogger(SelectionSort.class);

    @Override
    public void sort(char[] chars) {

        for (int i = 0; i < chars.length; i++) {
            LOG.info("Running selection w/ index entry i={}", i);
            char min = Character.MAX_VALUE;
            int to = i;
            for (int j = i; j < chars.length; j++) {
                if (chars[j] < chars[i] && chars[j] < min) {
                    to = j;
                    min = chars[j];
                }
            }
            swap(chars, i, to);
        }
        LOG.info("{}", chars);
    }
}
