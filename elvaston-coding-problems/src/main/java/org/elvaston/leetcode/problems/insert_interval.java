package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.datastructures.Interval;
import org.elvaston.leetcode.difficulty.hard;
import org.elvaston.leetcode.tags.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
@hard
@array
public class insert_interval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> results = new ArrayList<>();
        for (Interval interval : intervals) {
            if (newInterval == null || newInterval.start > interval.end) {
                results.add(interval);
            } else if (newInterval.end < interval.start) {
                results.add(newInterval);
                results.add(interval);
                newInterval = null;
            } else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        if (newInterval != null) {
            results.add(newInterval);
        }
        return results;
    }
}
