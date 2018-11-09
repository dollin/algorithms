package org.elvaston.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test case for the sorting algorithm implementations.
 */
public class SortTest {

    @Test
    public void selectionSort() {
        char[] example = "SELECTIONSORTEXAMPLE".toCharArray();
        new SelectionSort().sort(example);
        Assert.assertEquals("ACEEEEILLMNOOPRSSTTX", String.copyValueOf(example));
    }

    @Test
    public void defaultSort() {
        char[] example = "SELECTIONSORTEXAMPLE".toCharArray();
        new DefaultSort().sort(example);
        Assert.assertEquals("ACEEEEILLMNOOPRSSTTX", String.copyValueOf(example));
    }
}
