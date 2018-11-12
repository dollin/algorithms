package org.elvaston.sort;

import org.elvaston.api.Sort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

/**
 * Insertion sort.
 * The algorithm that people often use to sort bridge hands is to consider the cards one at a time, inserting each
 * into its proper place among those already considered (keeping them sorted).
 * In a computer implementation, we need to make space for the current item by moving larger items
 * one position to the right, before inserting the current item into the vacated position.
 * <p>
 * Proposition #1.
 * For randomly ordered arrays of length n with distinct keys, insertion sort uses ~(N^2)/4 compares
 * and ~(N^2)/4 exchanges on the average.
 * The worst case is ~(N^2)/2 compares and ~(N^2)/2 exchanges and the best case is N-1 compares and 0 exchanges.
 * Insertion sort works well for certain types of non-random arrays that often arise in practice, even if they are huge.
 * An inversion is a pair of keys that are out of order in the array. For instance, E X A M P L E has 11 inversions:
 * E-A, X-A, X-M, X-P, X-L, X-E, M-L, M-E, P-L, P-E, and L-E. If the number of inversions in an array is less than
 * a constant multiple of the array size, we say that the array is partially sorted.
 * </p>
 * <p>
 * Proposition #2.
 * The number of exchanges used by insertion sort is equal to the number of inversions in the array,
 * and the number of compares is at least equal to the number of inversions and at most equal to
 * the number of inversions plus the array size.
 * </p>
 */
public class InsertionSort implements Sort {

    private static final Logger LOG = LoggerFactory.getLogger(InsertionSort.class);

    @Override
    public void sort(char[] chars) {

        IntStream.range(1, chars.length).forEach(i -> {
            LOG.info("Running insertion w/ index entry i={}", i);
            int index = i;
            while (index > 0 && chars[index] < chars[index - 1]) {
                swap(chars, index, index - 1);
                index--;
            }
        });
        LOG.info("{}", chars);
    }
}
