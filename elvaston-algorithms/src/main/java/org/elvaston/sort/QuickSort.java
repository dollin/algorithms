package org.elvaston.sort;

import org.elvaston.api.Sort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Quicksort.
 * Quicksortis a divide-and-conquer method for sorting. It works by partitioning an array into two parts,
 * then sorting the parts independently. The crux of the method is the partitioning process,
 * which rearranges the array to make the following three conditions hold:
 * 1. The entry a[j] is in its final place in the array, for some j.
 * 2. No entry in a[lo] through a[j-1] is greater than a[j].
 * 3. No entry in a[j+1] through a[hi] is less than a[j].
 * We achieve a complete sort by partitioning, then recursively applying the method to the subarrays.
 * It is a randomized algorithm, because it randomly shuffles the array before sorting it.
 * <p>
 * Partitioning.
 * To complete the implementation, we need to implement the partitioning method. We use the following general strategy:
 * First, we arbitrarily choose a[lo] to be the partitioning item—the one that will go into its final position.
 * Next, we scan from the left end of the array until we find an entry that is greater than (or equal to) the
 * partitioning item, and we scan from the right end of the array until we find an entry less than (or equal to)
 * the partitioning item.
 * </p>
 * <p>
 * Proposition. Quicksort uses ~2 N ln N compares (and one-sixth that many exchanges)
 * on the average to sort an array of length N with distinct keys.
 * </p>
 */
public class QuickSort implements Sort {

    private static final Logger LOG = LoggerFactory.getLogger(QuickSort.class);

    @Override
    public void sort(char[] chars) {
        sort(chars, 0, chars.length - 1);
        LOG.info("{}", chars);
    }

    private void sort(char[] chars, int low, int high) {
        if (high <= low) {
            return;
        }
        int partition = partition(chars, low, high);
        sort(chars, low, partition - 1);
        sort(chars, partition + 1, high);
    }

    private int partition(char[] chars, int low, int high) {
        LOG.info("Partition w/ low: {}, high: {}", low, high);

        int indexToReassign = low;
        int indexOfPartition = high + 1;
        int valueToReassign = chars[low];
        while (true) {
            //Find a value higher than the one we want to fix
            while (chars[++indexToReassign] < valueToReassign) {
                if (indexToReassign == high) {
                    break;
                }
            }
            //Find a value lower than the one we want to fix
            while (valueToReassign < chars[--indexOfPartition]) {
                if (indexOfPartition == low) {
                    break;
                }
            }
            //In case we've crossed over
            if (indexToReassign >= indexOfPartition) {
                break;
            }
            //Put the lower number to the right, and the higher number to the left
            swap(chars, indexToReassign, indexOfPartition);
        }

        //Now we've done for all the array elements we can put our "low" index into its final place
        swap(chars, low, indexOfPartition);
        LOG.info("Partitioned index: {}", indexOfPartition);
        return indexOfPartition;
    }
}
