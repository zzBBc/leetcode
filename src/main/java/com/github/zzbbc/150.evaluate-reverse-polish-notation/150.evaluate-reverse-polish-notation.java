/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start

import java.util.Stack;

// Runtime: 5 ms
// Memory Usage: 44.88 MB
class Solution {

    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.valueOf(tokens[0]);
        }

        Stack<Integer> stack = new Stack<>();

        Integer first = null;
        Integer second = null;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    first = stack.pop();
                    second = stack.pop();
                    stack.add(second + first);
                    break;
                case "-":
                    first = stack.pop();
                    second = stack.pop();
                    stack.add(second - first);
                    break;
                case "*":
                    first = stack.pop();
                    second = stack.pop();
                    stack.add(second * first);
                    break;
                case "/":
                    first = stack.pop();
                    second = stack.pop();
                    stack.add(second / first);
                    break;
                default:
                    stack.add(Integer.valueOf(token));
                    continue;
            }
        }
        ;

        return Integer.valueOf(stack.peek());
    }
}
// @lc code=end
