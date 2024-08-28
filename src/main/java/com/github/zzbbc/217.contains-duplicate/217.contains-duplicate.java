/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

// Runtime: 7 ms
// Memory Usage: 61 MB
class Solution {
    private final Set<Integer> setList = new HashSet<>();

    public boolean containsDuplicate(int[] nums) {
        for (int i : nums) {
            if(!setList.add(i)){
                return true;
            };
        }

        return false;
    }
}
// @lc code=end

