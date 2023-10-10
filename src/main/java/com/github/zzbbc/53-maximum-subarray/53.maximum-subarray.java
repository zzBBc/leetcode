/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start

// Runtime: 15 ms
// Memory Usage: 59.60 MB
class Solution {

    public int maxSubArray(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }

        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    private int maxSubArrayHelper(int[] nums, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return nums[startIndex];
        }

        int midIndex = (startIndex + endIndex) / 2;

        int leftMax = maxSubArrayHelper(nums, startIndex, midIndex);
        int rightMax = maxSubArrayHelper(nums, midIndex + 1, endIndex);
        int maxCross = maxCrossArrayHelper(nums, startIndex, midIndex, endIndex);

        return Math.max(Math.max(rightMax, leftMax), maxCross);
    }

    private int maxCrossArrayHelper(int[] nums, int startIndex, int midIndex, int endIndex) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = midIndex; i >= startIndex; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = midIndex + 1; i <= endIndex; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }

        return leftSum + rightSum;
    }

}
// @lc code=end

