package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.recursion;

/**
 * https://leetcode.com/problems/k-th-symbol-in-grammar/
 *
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01,
 * and each occurrence of 1 with 10.
 *
 * Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).
 *
 * Input: N = 1, K = 1
 * Output: 0
 *
 * Input: N = 2, K = 1
 * Output: 0
 *
 * Input: N = 2, K = 2
 * Output: 1
 *
 * Input: N = 4, K = 5
 * Output: 1
 *
 * Explanation:
 * row 1: 0
 * row 2: 0    1
 * row 3: 01   10
 * row 4: 01101001
 *
 * N will be an integer in the range [1, 30].
 * K will be an integer in the range [1, 2^(N-1)].
 */
@medium
@recursion
public class kth_symbol_in_grammar {
    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }
        if (N == 2) {
            return K == 1 ? 0 : 1;
        }
        int len = (int) Math.pow(2, N - 1);
        if (K <= len / 2) {
            return kthGrammar(N - 1, K);
        }
        if (N % 2 == 0) {
            return kthGrammar(N -1, len - K + 1) == 1 ? 0 : 1;
        }
        return kthGrammar(N -1, len - K + 1);
    }

    public static void main(String[] args) {
        System.out.println(new kth_symbol_in_grammar().kthGrammar(4, 6));
    }
}
