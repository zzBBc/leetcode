/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start

import java.util.Arrays;

// Runtime: 35 ms
// Memory Usage: 55.9 MB
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            int value = nums[i];
            if (value == nums[i + 1]) {
                return value;
            }
        }
        return -1;
    }
}
// @lc code=end

