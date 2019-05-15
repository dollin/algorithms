package org.elvaston.daily_coding_problem;

/**
 * Given an array of ints return the an array where each element is the product of the array for
 * all values except the one at its index
 * Eg, [1,2,3,4] = [24,12,8,6]
 */
public class product {

    public int[] product(int[] nums) {

        /**
         * if we think os this as a 2D grid where bottom_left (i) has the product of the row
         * to the left of the coord being omitted. And the top_right (o) has the product of the row to the right.
         * X o o o
         * i X o o
         * i i X o
         * i i i X
         * Then we just to
         */
        int[] left_triangle_products = new int[nums.length];
        left_triangle_products[0] = 1;
        for (int i = 1; i < left_triangle_products.length; i++) {
            left_triangle_products[i] = left_triangle_products[i-1] * nums[i-1];
        }

        int[] right_triangle_products = new int[nums.length];
        right_triangle_products[right_triangle_products.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            right_triangle_products[i] = right_triangle_products[i+1] * nums[i+1];
        }

        int[] prod = new int[nums.length];
        for (int i = 0; i < prod.length; i++) {
            prod[i] = left_triangle_products[i] * right_triangle_products[i];
        }

        return prod;
    }

    public static void main(String[] args) {
        product p = new product();
        for (int i : p.product(new int[]{1,2,3,4,5})){
            System.out.print(i + ", ");
        }
    }
}
