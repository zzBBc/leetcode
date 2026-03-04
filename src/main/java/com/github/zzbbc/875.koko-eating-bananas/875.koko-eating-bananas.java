/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start

// Runtime: 26ms
// Memory Usage: 48.02MB
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = maxBananaInPiles(piles);

        int response = right;

        while (left <= right) {
            int k = (left + right) / 2;

            if (this.calculateTime(piles, k) <= h) {
                response = k;
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return response;
    }

    private long calculateTime(int[] piles, int k) {
        long totalTime = 0;

        for (int pile : piles) {
            totalTime += Math.ceil((double) pile / k);
        }

        return totalTime;
    }

    private int maxBananaInPiles(int[] piles) {
        int maxBanana = -1;
        for (int number : piles) {
            maxBanana = Math.max(maxBanana, number);
        }

        return maxBanana;
    }
}
// @lc code=end

