/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start

// Runtime: 1ms
// Memory Usage: 94.32MB
class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, j = 1;
        int profit = 0;

        while (j < prices.length) {
            if (prices[i] < prices[j]) {
                profit = Math.max(prices[j] - prices[i], profit);
            } else {
                i = j;
            }
            j++;
        }

        return profit;
    }
}
// @lc code=end
