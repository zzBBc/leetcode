/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start

import java.util.Arrays;

// Runtime: 1 ms
// Memory Usage: 41.1 MB
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length >= nums2.length) {
            mergeInternal(nums1, m, nums2, n);
        } else {
            mergeInternal(nums2, n, nums1, m);
        }
    }

    private void mergeInternal(int[] nums1, int m, int[] nums2, int n) {
        int totalLength = m + n;

        for (int i = m; i < totalLength; i++) {
            nums1[i] = nums2[i - m];
        }

        Arrays.sort(nums1);
    }
}
// @lc code=end

