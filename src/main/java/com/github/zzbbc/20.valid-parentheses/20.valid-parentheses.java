/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Runtime: 3 ms
// Memory Usage: 42.47 MB
class Solution {
    public static final Map<String, String> bracketPair = new HashMap<>();
    static {
        bracketPair.put("{", "}");
        bracketPair.put("(", ")");
        bracketPair.put("[", "]");
    }

    public boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }

        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();

        for (char character : chars) {
            String characterString = String.valueOf(character);
            if (bracketPair.keySet().contains(characterString)) {
                stack.add(String.valueOf(characterString));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                String closeBracket = bracketPair.get(stack.pop());
                if (!closeBracket.equals(characterString)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
// @lc code=end
