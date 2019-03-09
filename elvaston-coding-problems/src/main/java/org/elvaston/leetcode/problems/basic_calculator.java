package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.hard;
import org.elvaston.leetcode.tags.math;
import org.elvaston.leetcode.tags.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * Example 1:
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
@hard
@math
@stack
public class basic_calculator {

    public static void main(String[] args) {
        System.out.println("-1,001 =" + calculate("-1 - 1000"));
        System.out.println("2 =" + calculate("1 + 1"));
        System.out.println("2 =" + calculate("1 - (1 - (1 + 1))"));
        System.out.println("-65 =" + calculate("(1 - (44 + 22)"));
        System.out.println("95 =" + calculate("1 + 100 - (2 + 4)"));
        System.out.println("23 =" + calculate("1+(4+5+2)-3+(6+8)"));
    }

    /**
     * Trying to make unique. Ideally if we have a -ve number we should put a MINUS onto the stack followed by the
     * +ve value. Then all values on the stack are away from the statics references below
     */
    private static int OPEN_PARA = -2245451;
    private static int PLUS = -440200346;
    private static int MINUS = -44020032;


    private static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {

            } else if (s.charAt(i) == '-') {
                stack.push(MINUS);
            } else if (s.charAt(i) == '+') {
                stack.push(PLUS);
            } else if (s.charAt(i) == '(') {
                stack.push(OPEN_PARA);
            } else if (s.charAt(i) == ')') {
                int value = getValue(stack);
                if (!stack.isEmpty() && stack.peek() == OPEN_PARA) {
                    stack.pop(); // pop open para
                }
                stack.push(value);

            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int val = s.charAt(i) - '0';
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    i++;
                    val = (val * 10) + (s.charAt(i) - '0');
                }
                stack.push(val);
            }
        }
        return getValue(stack);
    }

    private static int getValue(Stack<Integer> stack) {
        int value = 0;

        while (!stack.isEmpty() && stack.peek() != OPEN_PARA) {
            int val = stack.pop();
            if (!stack.isEmpty() && stack.peek() == MINUS
                    && val != PLUS
                    && val != OPEN_PARA
                    && val != MINUS) {
                value -= val;
            } else if ((!stack.isEmpty() && stack.peek() != MINUS)
                    && val != PLUS
                    && val != OPEN_PARA
                    && val != MINUS) {
                value += val;
            } else if (stack.isEmpty()
                    && val != PLUS
                    && val != OPEN_PARA
                    && val != MINUS) {
                value += val;
            }
        }
        return value;
    }
}
