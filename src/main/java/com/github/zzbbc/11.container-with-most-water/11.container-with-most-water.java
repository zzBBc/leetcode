/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start

// Runtime: 5 ms
// Memory Usage: 57.66 MB
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int currentAreaHeight = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int width = right - left;

            int currentHeight = Math.min(height[left], height[right]);

            int currentArea = width * currentHeight;
            if (currentArea > maxArea) {
                maxArea = currentArea;
                currentAreaHeight = currentHeight;
            }

            if (height[left] <= currentAreaHeight) {
                left++;
            } else if (height[right] <= currentAreaHeight) {
                right--;
            } else {
                if (height[left] < height[left + 1]) {
                    left++;
                } else if (height[right] < height[right - 1]) {
                    right--;
                } else {
                    if (height[left] >= height[right]) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return maxArea;
    }
}
// @lc code=end
