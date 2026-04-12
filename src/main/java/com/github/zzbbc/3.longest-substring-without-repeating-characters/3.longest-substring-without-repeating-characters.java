/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start

// Runtime: 1ms
// Memory Usage: 44.22MB
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;

        int longest = 1;
        while (right < s.length() - 1) {
            longest = Math.max(right - left + 1, longest);
            char currentChar = s.charAt(right + 1);

            for (int i = left; i <= right; i++) {
                if (s.charAt(i) == currentChar) {
                    left = i + 1;
                    break;
                }
            }

            right++;
        }

        return Math.max(right - left + 1, longest);
    }
}
// @lc code=end
