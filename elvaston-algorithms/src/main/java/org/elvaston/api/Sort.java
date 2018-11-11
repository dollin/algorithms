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

    default void sort(char[] chars) {
        Arrays.sort(chars);
    }

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

    default void swap(char[] chars, int from, int to) {
        char tmp = chars[from];
        chars[from] = chars[to];
        chars[to] = tmp;
        LOG.info("{}", chars);
    }
}
