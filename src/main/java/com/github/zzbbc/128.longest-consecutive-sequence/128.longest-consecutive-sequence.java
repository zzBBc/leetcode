/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start

import java.util.Arrays;

// Runtime: 19 ms
// Memory Usage: 57.14 MB
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);

        int response = 1;
        int streak = 1;
        int currentValue = nums[0];
        int i = 0;
        while (i < nums.length - 1) {
            int nextValue = nums[i+1];

            int diff = nextValue - currentValue;
            if(diff > 1){
                streak = 1;
            } else {
                if(diff == 1){
                    streak++;
                }
            }
            
            response = Math.max(response, streak);
            currentValue = nextValue;
            i++;
        }

        return response;
    }
}
// @lc code=end

