/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

// Runtime: 1 ms
// Memory Usage: 43.32MB
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        backTracking(parenthesis, "", 0, 0, n);

        return parenthesis;
    };

    private void backTracking(List<String> parenthesis, String subParenthesis,
            int indexOpen, int indexClose, int n) {
        if (indexOpen == n && indexClose == n) {
            parenthesis.add(subParenthesis.toString());

            return;
        }

        if (indexOpen < n) {
            backTracking(parenthesis, subParenthesis + "(", indexOpen + 1, indexClose, n);
        }

        if (indexOpen > indexClose) {
            backTracking(parenthesis, subParenthesis + ")", indexOpen, indexClose + 1, n);
        }
    }
}
// @lc code=end

