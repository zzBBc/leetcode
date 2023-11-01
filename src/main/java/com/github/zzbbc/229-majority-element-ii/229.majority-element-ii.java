/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Runtime: 5 ms
// Memory Usage: 47.1 MB
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);

        int greater = nums.length / 3;

        int count = 0;
        int currentNumber = nums[0];

        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (currentNumber == i) {
                if (++count > greater) {
                    if (list.contains(i)) {
                        continue;
                    }

                    list.add(i);
                }
            } else {
                currentNumber = i;
                count = 0;
                if (++count > greater) {
                    if (list.contains(i)) {
                        continue;
                    }

                    list.add(i);
                }
            }
        }

        return list;
    }
}
// @lc code=end


