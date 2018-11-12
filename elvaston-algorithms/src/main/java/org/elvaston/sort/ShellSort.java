package org.elvaston.sort;

import org.elvaston.api.Sort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Shellsort.
 * Shellsort is a simple extension of insertion sort that gains speed by allowing exchanges of entries that are far
 * apart, to produce partially sorted arrays that can be efficiently sorted, eventually by insertion sort.
 * The idea is to rearrange the array to give it the property that taking every h^th entry (starting anywhere)
 * yields a sorted sequence. Such an array is said to be h-sorted.
 * By h-sorting for some large values of h, we can move entries in the array long distances and thus make
 * it easier to h-sort for smaller values of h. Using such a procedure for any increment sequence of values of h
 * that ends in 1 will produce a sorted array.
 * <p>
 * Property. The number of compares used by shellsort w/ increments 1, 4, 13, 40, 121, 364, ... is bounded by a
 * small multiple of N times the number of increments used.
 * </p>
 * <p>
 * Proposition. The number of compares used by shellsort w/ increments 1, 4, 13, 40, 121, 364, ... is O(N^(3/2)).
 * </p>
 */
public class ShellSort implements Sort {
    private static final Logger LOG = LoggerFactory.getLogger(ShellSort.class);

    @Override
    public void sort(char[] chars) {

        int h = 1;
        while (h < chars.length) {
            h = (h * 3) + 1;
        }

        while (h >= 1) {
            LOG.info("Running shell w/ every h={} th entry", h);
            for (int i = h; i < chars.length; i++) {
                for (int j = i; j >= h && chars[j] < chars[j - h]; j -= h) {
                    swap(chars, j, j-h);
                }
            }
            h /= 3;
        }
        LOG.info("{}", chars);
    }
}
