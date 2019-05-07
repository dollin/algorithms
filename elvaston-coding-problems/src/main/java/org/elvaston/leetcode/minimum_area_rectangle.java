package org.elvaston.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-area-rectangle/
 *
 * Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.
 *
 * If there isn't any rectangle, return 0.
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
 * Output: 4
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
 * Output: 2
 *
 * Note:
 * 1 <= points.length <= 500
 * 0 <= points[i][0] <= 40000
 * 0 <= points[i][1] <= 40000
 * All points are distinct.
 */
public class minimum_area_rectangle {
    public static void main(String[] args) {
        minimum_area_rectangle solution = new minimum_area_rectangle();
        System.out.println(solution.getArea(new int[][]{{1,1},{1,3},{3,1},{3,3},{2,2}}));
        System.out.println(solution.getArea(new int[][]{{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}}));
    }

    private int getArea(int[][] points) {
        int area = Integer.MAX_VALUE;

        Map<Integer, List<Integer>> values = new HashMap<>();
        for (int[] coord : points) {
            values.putIfAbsent(coord[0], new ArrayList<>());
            values.get(coord[0]).add(coord[1]);
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                    if (makeRectangle(values, points[i], points[j])) {
                        area = Math.min(area, (Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1])));
                    }
                }
            }
        }
        return area;
    }

    private boolean makeRectangle(Map<Integer, List<Integer>> values, int[] first, int[] second) {
        List<Integer> fromFirst = values.get(first[0]);
        List<Integer> fromSecond = values.get(second[1]);
        return fromFirst != null && fromFirst.contains(second[1]) && fromSecond != null && fromSecond.contains((first[0]));
    }
}
