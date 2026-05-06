/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

// Runtime: 21ms
// Memory Usage: 48.10MB
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int required = targetMap.size();

        int found = 0;
        int minSize = Integer.MAX_VALUE;

        char[] characterArray = s.toCharArray();

        int left = 0;
        int minLeft = 0;
        int right = 0;
        while (right < characterArray.length) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (targetMap.containsKey(c) && windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                found++;
            }

            while (left <= right && required == found) {
                if (right - left + 1 < minSize) {
                    minSize = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.getOrDefault(leftChar, 0) - 1);

                if (targetMap.containsKey(leftChar)
                        && windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
                    found--;
                }

                left++;
            }

            right++;
        }

        return minSize == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minSize);

    }
}
// @lc code=end
