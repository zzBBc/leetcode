/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start

import java.util.PriorityQueue;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length) {
            return new int[0];
        }

        int[] max = new int[nums.length - k + 1];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i, j) -> nums[j] - nums[i]);
        for (int i = 0; i < k; i++) {
            maxHeap.offer(i);
        }

        max[0] = nums[maxHeap.peek()];

        for (int i = k; i < nums.length; i++) {
            maxHeap.offer(i);

            while (maxHeap.peek() < i - k) {
                maxHeap.poll();
            }

            max[i - k + 1] = nums[maxHeap.peek()];
        }

        return max;
    }

}
// @lc code=end
