package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.tags.depth_first_search;
import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/
 *
 * Given an encoded string, return it's decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
@medium
@depth_first_search
@stack
public class decode_string {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
            if (stack.peek() == ']') {
                stack.pop();
                String str = "";
                while (stack.peek() != '[') {
                    str = stack.pop() + str;
                }
                stack.pop(); //remove [

                String times = "" + ((int) stack.pop() - '0');
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    times = ((int) stack.pop() - '0') + times;
                }
                for (int i = 0; i < Integer.valueOf(times); i++) {
                    for (char c1 : str.toCharArray()) {
                        stack.push(c1);
                    }
                }
            }
        }
        String decodedStr = "";
        while (!stack.isEmpty()) {
            decodedStr = stack.pop() + decodedStr;
        }
        return decodedStr;
    }
}
