/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

// Right answer but wrong in leetcode
class Solution {
    private static final Map<Integer, Integer> map = new HashMap<>();

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        for (int i : nums) {
            if (map.containsKey(i)) {
                Integer count = map.get(i) + 1;

                if (count > nums.length / 2) {
                    return i;
                }

                map.put(i, count);
            } else {
                map.put(i, 1);
            }
        }

        return 0;
    }
}
// @lc code=end

