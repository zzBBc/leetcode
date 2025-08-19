/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start

import java.util.Stack;

// Runtime: 59 ms
// Memory Usage: 56.16 MB
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] response = new int[temperatures.length];

        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];

            while (!stack.isEmpty() && temperature > stack.peek()[0]) {
                int[] current = stack.pop();

                response[current[1]] = i - current[1];
            }

            stack.push(new int[] {temperature, i});
        }

        return response;
    }
}
// @lc code=end

