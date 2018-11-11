package org.elvaston.api;

import org.elvaston.sort.SelectionSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Sort interface.
 */
public interface Sort {

    Logger LOG = LoggerFactory.getLogger(SelectionSort.class);

    /**
     * Sort the given char array.
     * Uses {@code Arrays.sort} by default
     * @param chars the array to sort
     */
    default void sort(char[] chars) {
        Arrays.sort(chars);
    }

    /**
     * To log the from and to indexes that we are switching.
     * @param chars the array whose length to use
     * @param from the index to swap from
     * @param to the index to swap into
     */
    default void logSwitches(char[] chars, int from, int to) {
        StringBuffer sb = new StringBuffer("[");
        for (int i = 0; i < chars.length; i++) {
            if (i == from) {
                sb.append(">");
            } else if (i == to) {
                sb.append("<");
            } else {
                sb.append(" ");
            }
            sb.append("  ");
        }
        sb.replace(sb.lastIndexOf("  "), sb.length(), "]");
        LOG.info("{}", sb);
    }

    /**
     * Swap two array elements.
     * @param chars the array to use
     * @param from the index to swap from
     * @param to the index to swap into
     */
    default void swap(char[] chars, int from, int to) {
        char tmp = chars[from];
        chars[from] = chars[to];
        chars[to] = tmp;
        LOG.info("{}", chars);
    }
}
