package org.elvaston.api;

import java.util.Arrays;

/**
 * Sort interface.
 */
public interface Sort {

    default void sort(char[] chars) {
        Arrays.sort(chars);
    }
}
