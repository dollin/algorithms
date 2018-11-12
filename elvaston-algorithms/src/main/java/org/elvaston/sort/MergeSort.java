package org.elvaston.sort;

import org.elvaston.api.Sort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MergeSort.
 * We use a merge(chars, lo, mid, hi) that puts the results of merging the subarrays chars[lo..mid] w/ chars[mid+1..hi]
 * into a single ordered array, leaving the result in a[lo..hi]. While it would be desirable to implement this
 * method without using a significant amount of extra space, such solutions are remarkably complicated.
 * Instead, merge() copies everything to an auxiliary array and then merges back to the original.
 * <p>
 * Proposition. MergeSort uses between 1/2 N lg N and N lg N compares and at most 6 N lg N array accesses
 * to sort any array of length N
 * </p>
 * <p>
 * Improvements.
 * We could cut the running time w/ some carefully considered modifications to the implementation.
 * 1. Use insertion sort for small subarrays
 * 2. Test whether array is already in order
 * 3. Eliminate the copy to the auxiliary array
 * </p>
 */
public class MergeSort implements Sort {

    private static final Logger LOG = LoggerFactory.getLogger(MergeSort.class);

    @Override
    public void sort(char[] chars) {
        char[] aux = new char[chars.length];
        sort(chars, aux, 0, chars.length - 1);
        LOG.info("{}", chars);
    }

    private void sort(char[] chars, char[] aux, int low, int high) {
        if (high <= low) {
            return;
        }
        int midpoint = low + (high - low) / 2;
        sort(chars, aux, low, midpoint);
        sort(chars, aux, midpoint + 1, high);

        merge(chars, aux, low, midpoint, high);
    }

    private void merge(char[] chars, char[] aux, int low, int midpoint, int high) {
        LOG.info("Merge : {}", chars);
        logSwitches(chars, low, high);

        System.arraycopy(chars, low, aux, low, high + 1 - low);

        int auxLowIndex = low;
        int auxHighIndex = midpoint + 1;
        for (int k = low; k <= high; k++) {
            if (auxLowIndex > midpoint) {
                chars[k] = aux[auxHighIndex++];
            } else if (auxHighIndex > high) {
                chars[k] = aux[auxLowIndex++];
            } else if (aux[auxHighIndex] < aux[auxLowIndex]) {
                chars[k] = aux[auxHighIndex++];
            } else {
                chars[k] = aux[auxLowIndex++];
            }
        }
    }
}
