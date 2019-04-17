package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.hard;
import org.elvaston.leetcode.tags.array;
import org.elvaston.leetcode.tags.two_pointers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap_with_2_pointers after raining.
 *                      ||
 *          || ** ** ** || || ** ||
 *    || ** || || ** || || || || || ||
 * -- -- -- -- -- -- -- -- -- -- -- --
 * 0  1  2  3  4  5  6  7  8  9  10 11
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (**) are being trapped.
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
@hard
@array
@two_pointers
public class trapping_rain_water {
    public int trap_brute_force(int[] elevations) {
        int max_height = Arrays.stream(elevations).max().getAsInt();
        int total_rain = 0;
        for (int i = 0; i <= max_height; i++) {
            boolean is_open = false;
            int rain_at_height = 0;
            for (int elevation : elevations) {
                if (elevation > i) {
                    if (is_open) {
                        total_rain += rain_at_height;
                        rain_at_height = 0;
                    } else {
                        is_open = true;
                    }
                } else if (is_open) {
                    rain_at_height++;
                }
            }
        }
        return total_rain;
    }

    public int trap_with_2_pointers(int[] heights) {
        int left_index = 0;
        int right_index = heights.length - 1;

        int left_height = 0;
        int right_height = 0;

        int trapped_rain = 0;

        while (left_index < right_index) {
            if (heights[left_index] < heights[right_index]) {

                left_height = Math.max(left_height, heights[left_index]);
                trapped_rain += left_height - heights[left_index];
                left_index++;
            } else {
                right_height = Math.max(right_height, heights[right_index]);
                trapped_rain += right_height - heights[right_index];
                right_index--;
            }
        }
        return trapped_rain;
    }

    public static void main(String[] args) {
        System.out.println(new trapping_rain_water().trap_with_2_pointers(new int[]{1,1,2}));
        System.out.println(new trapping_rain_water().trap_with_2_pointers(new int[]{1,3,2}));
        System.out.println(new trapping_rain_water().trap_with_2_pointers(new int[]{2}));
        System.out.println(new trapping_rain_water().trap_with_2_pointers(new int[]{0}));
        System.out.println(new trapping_rain_water().trap_with_2_pointers(new int[]{}));
        System.out.println(new trapping_rain_water().trap_with_2_pointers(new int[]{1,0,2}));
        System.out.println(new trapping_rain_water().trap_with_2_pointers(new int[]{3,0,2}));
        System.out.println(new trapping_rain_water().trap_with_2_pointers(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(new trapping_rain_water().trap_with_2_pointers(new int[]{0,2,0,1,0,31,1,1}));
    }
}
