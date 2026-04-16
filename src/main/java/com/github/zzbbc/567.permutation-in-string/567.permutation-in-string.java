/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

// Runtime:  41ms
// Memory Usage: 46.90MB
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> countChar = new HashMap<>();
        for (char character : s1.toCharArray()) {
            countChar.merge(character, 1, Integer::sum);
        }

        int left = 0;
        int right = s1.length() - 1;
        Map<Character, Integer> currentMap = new HashMap<>();
        for (int i = left; i <= right; i++) {
            currentMap.merge(s2.charAt(i), 1, Integer::sum);
        }

        while (right >= 0 && right < s2.length()) {
            if (countChar.equals(currentMap)) {
                return true;
            }

            currentMap.merge(s2.charAt(left), -1, Integer::sum);
            if (currentMap.get(s2.charAt(left)) == 0) {
                currentMap.remove(s2.charAt(left));
            }
            left++;
            right++;

            if (right < s2.length()) {
                currentMap.merge(s2.charAt(right), 1, Integer::sum);
            }
        }

        return false;
    }
}
// @lc code=end
