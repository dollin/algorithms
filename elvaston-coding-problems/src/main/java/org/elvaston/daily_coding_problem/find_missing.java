package org.elvaston.daily_coding_problem;

/**
 * Problem #4
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 */
public class find_missing {

    public int findMissing(int[] nums) {
        boolean[] hasNumber = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && nums[i] < nums.length) {
                hasNumber[nums[i]] = true;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (!hasNumber[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        find_missing solution = new find_missing();
        System.out.println("3= " + solution.findMissing(new int[]{0,1,2}));
        System.out.println("2= " + solution.findMissing(new int[]{1,-1,3,4}));
    }
}
