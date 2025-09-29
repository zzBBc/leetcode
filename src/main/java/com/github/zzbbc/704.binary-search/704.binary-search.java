/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start

// Runtime: 0ms
// Memory Usage: 45.94MB
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int i, int n) {
        if (n - i <= 0) {
            if (i == n) {
                if (nums[i] == target) {
                    return i;
                }
            }

            return -1;
        }


        int j = i + (n - i) / 2;

        if (nums[j] == target) {
            return j;
        } else if (nums[j] < target) {
            return binarySearch(nums, target, j + 1, n);
        } else {
            return binarySearch(nums, target, i, j - 1);
        }
    }
}
// @lc code=end

