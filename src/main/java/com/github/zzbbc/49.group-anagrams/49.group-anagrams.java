/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

// Runtime: 7 ms
// Memory Usage: 47.6 MB

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            map.putIfAbsent(sortedWord, new ArrayList<>());
            
            map.get(sortedWord).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
}
// @lc code=end

