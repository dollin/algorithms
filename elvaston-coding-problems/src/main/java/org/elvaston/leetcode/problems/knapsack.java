package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.medium;

@medium
public class knapsack {

    public int knapsack(int[] wghts, int[] vals, int W) {

        int[][] matrix = new int[vals.length + 1][W + 1];
        /**
         * For each i we are saying can I add element at index i from the wghts, vals
         * For each j we are going through a knapsack of size j until we get the the total size
         */
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                } else if (wghts[i - 1] <= j) {
                    /**
                     * when setting a given value we take max from: -
                     * 1. the already calculated max from the row above, or...
                     * 2. A + B, where A: the value for this item: vals[i - 1]
                     *                 B: the already calculated max in the row above of this matrix
                     *                    but we need to remove the weight we are adding in A from the overall weight of
                     *                    j (where j is the knapsack)
                     */
                    matrix[i][j] = Math.max(
                            vals[i - 1] + matrix[i - 1][j - wghts[i - 1]],
                            matrix[i - 1][j]);
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
        return matrix[vals.length][W];
    }

    public static void main(String[] args) {
        knapsack knapsack = new knapsack();
        //                                   weights              , values                  , sizeOfSack
        System.out.println(knapsack.knapsack(new int[]{1, 2, 3, 4}, new int[]{6, 10, 12, 10}, 5));
    }
}
