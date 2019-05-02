package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.two_pointers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/interval-list-intersections/
 *
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 * Return the intersection of these two interval lists.
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 * The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.
 * For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 *
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 */
@medium
@two_pointers
public class interval_list_intersections {

    public static void main(String[] args) {
        interval_list_intersections solution = new interval_list_intersections();
        solution.intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}}, new int[][]{{1,5},{8,12},{15,24},{25,26}});
        solution.intervalIntersection(new int[][]{{0,3},{4,10}}, new int[][]{{3,5},{8,12},{15,24},{25,26}});
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> inters = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            if (A[i][1] >= B[j][0] && A[i][0] <= B[j][1]) {
                inters.add(new int[]{Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])});
            }
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] intersections = new int[inters.size()][2];
        inters.toArray(intersections);
        for (int[] inter : intersections) {
            System.out.print("[" + inter[0] + "," + inter[1] +"], ");
        }
        System.out.println();
        return intersections;
    }
}
