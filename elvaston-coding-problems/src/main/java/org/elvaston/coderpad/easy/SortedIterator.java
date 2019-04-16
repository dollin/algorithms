package org.elvaston.coderpad.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Implement a sorted java iterator that returns a sorted list over k sorted lists
 *
 * Input:
 * [[1, 4, 5, 8, 9],
 * [3, 4, 4, 6],
 * [0, 2, 8]]
 * Output:
 * 0, 1, 2, 3, 4, 4, 4, 5, 6, 8, 8, 9
 */
public class SortedIterator implements Iterator<Integer> {

    int length = 0;
    private List<List<Integer>> lists;
    private int[] counters;

    public SortedIterator(List<List<Integer>> lists) {
        this.lists = lists;
        counters = new int[lists.size()];
        int index = 0;
        for (List<Integer> i : lists) {
            counters[index++] = 0;
            length += i.size();
        }
    }

    @Override
    public boolean hasNext() {
        return counters != null && Arrays.stream(counters).sum() < length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < counters.length; i++) {
            List<Integer> l = lists.get(i);
            if (l.size() > counters[i]) {
                int val = l.get(counters[i]);
                if (min > val) {
                    min = val;
                    index = i;
                }
            }
        }
        counters[index]++;
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(4);
        a.add(5);
        a.add(8);
        a.add(9);

        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);
        b.add(4);
        b.add(6);

        List<Integer> c = new ArrayList<>();
        c.add(0);
        c.add(2);
        c.add(8);

        lists.add(a);
        lists.add(b);
        lists.add(c);

        SortedIterator it = new SortedIterator(lists);
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
    }
}
