/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Runtime:  21ms
// Memory Usage: 46.66MB
class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;

        Set<Character> characters = new HashSet<>();
        for (char character : s.toCharArray()) {
            characters.add(character);
        }

        for (Character character : characters) {
            int count = 0;
            int left = 0;

            for (int right = 0; right < s.length(); right++) {
                if (s.charAt(right) == character) {
                    count++;
                }

                while ((right - left + 1) - count > k) {
                    if (s.charAt(left) == character) {
                        count--;
                    }

                    left++;
                }

                result = Math.max(result, right - left + 1);

            }
        }

        return result;
    }
}
// @lc code=end
