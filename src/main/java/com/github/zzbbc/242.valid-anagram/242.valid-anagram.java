/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

// Runtime: 459 ms
// Memory Usage: 44.4 MB
class Solution {
    public boolean isAnagram(String s, String t) {
        List<Character> chars = new ArrayList<>(s.length());

        for (Character character : s.toCharArray()) {
            chars.add(character);
        }

        for (Character character : t.toCharArray()) {
            if(!chars.contains(character)){
                return false;
            }

            chars.remove(character);
        }

        return chars.isEmpty();
    }
}
// @lc code=end

