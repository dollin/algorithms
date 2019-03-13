package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.depth_first_search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/increasing-subsequences/
 *
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .
 *
 * Example:
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * Note:
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 */
@medium
@depth_first_search
public class increasing_subsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> sequences = new ArrayList<>();
        addPairs(sequences, nums);

        addNext(sequences, nums);

        return transferIndexes(sequences, nums);
    }

    private List<List<Integer>> transferIndexes(List<List<Integer>> sequences, int[] nums) {
        List<List<Integer>> val_sequences = new ArrayList<>();
        for (List<Integer> seq : sequences) {
            List<Integer> new_seq = seq.stream().mapToInt(value -> nums[value]).boxed().collect(Collectors.toList());
            if (!val_sequences.contains(new_seq)) {
                val_sequences.add(new_seq);
            }
        }
        return val_sequences;
    }

    private void addNext(List<List<Integer>> sequences, int[] nums) {
        for (int k = 2; k < nums.length; k++) {
            List<List<Integer>> next_sequences = new ArrayList<>();
            for (List<Integer> seq : sequences) {
                if (seq.size() < k) {
                    continue;
                }
                int val = nums[seq.get(seq.size() - 1)];
                for (int i = seq.get(seq.size() - 1) + 1; i < nums.length; i++) {
                    if (val <= nums[i]) {
                        List<Integer> next_seq = new ArrayList<>();
                        for (int j : seq) {
                            next_seq.add(j);
                        }
                        next_seq.add(i);
                        next_sequences.add(next_seq);
                    }
                }
            }
            sequences.addAll(next_sequences);
        }
    }

    private void addPairs(List<List<Integer>> sequences, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> seq = new ArrayList<>();
                if (nums[i] <= nums[j]) {
                    seq.add(i);
                    seq.add(j);
                    if (!sequences.contains(seq)) {
                        sequences.add(seq);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        increasing_subsequences is = new increasing_subsequences();
        System.out.println("[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7, 7], [4, 7, 7]]\n" + is.findSubsequences(new int[]{4, 6, 7, 7}));
        System.out.println("[[7, 8], [6, 8]]\n" + is.findSubsequences(new int[]{7, 6, 8, 4}));
        System.out.println("[[7, 7]]\n" + is.findSubsequences(new int[]{7, 7, 6, 4}));
    }
}
