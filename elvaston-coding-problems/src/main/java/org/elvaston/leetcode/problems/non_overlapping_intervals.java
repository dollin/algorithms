package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.Interval;
import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 *
 * Given a collection of intervals, find the MINIMUM number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 *
 * Input: [ [1,2], [2,3], [3,4], [1,3] ]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 *
 * Input: [ [1,2], [1,2], [1,2] ]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 *
 * Input: [ [1,2], [2,3] ]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */
@medium
@greedy
public class non_overlapping_intervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));

        int count = 0;
        int ptr = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            if (ptr <= interval.start) {
                ptr = interval.end;
            } else {
                count++;
                ptr = Math.min(ptr, interval.end);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        non_overlapping_intervals solution = new non_overlapping_intervals();
        System.out.println("1= " + solution.eraseOverlapIntervals(new Interval[]{new Interval(0, 3), new Interval(0, 1), new Interval(1, 3)}));
        System.out.println("2= " + solution.eraseOverlapIntervals(new Interval[]{new Interval(1, 2), new Interval(1, 2), new Interval(1, 2)}));
        System.out.println("0= " + solution.eraseOverlapIntervals(new Interval[]{new Interval(1, 2), new Interval(2, 3)}));
    }
}
