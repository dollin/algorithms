package org.elvaston.leetcode.problems;

import static java.util.Collections.reverse;

import org.elvaston.leetcode.difficulty.easy;
import org.elvaston.leetcode.tags.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 *
 * For a non-negative integer X, the array-form of X is an array of its digits in left to right order.
 * For example, if X = 1231, then the array form is [1,2,3,1].
 *
 * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
 *
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 *
 * Input: A = [2,7,4], K = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 *
 * Input: A = [2,1,5], K = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 *
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 *
 *
 * Note：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * If A.length > 1, then A[0] != 0
 */
@easy
@array
public class add_to_array_form_of_integer {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        int spare = 0;
        for (int index = A.length - 1; index >= 0; index--) {
            int amt = spare + A[index] + (K % 10);
            result.add(amt % 10);
            spare = amt / 10;
            K /= 10;
        }
        if (spare > 0) {
            result.add(spare);
        }
        reverse(result);
        return result;
    }

    public static void main(String[] args) {
        add_to_array_form_of_integer soln = new add_to_array_form_of_integer();
        System.out.println(soln.addToArrayForm(new int[]{1,9,9}, 10));
    }
}
