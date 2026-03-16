/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start

// Runtime: 2 ms
// Memory Usage: 60.62 MB
class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;

        if (length <= 1) {
            return 0;
        }

        int buyPrice = Integer.MAX_VALUE;
        int buyIndex = -1;

        int sellPrice = Integer.MIN_VALUE;
        int matchedBuy = 0;
        for (int i = 0; i < length; i++) {
            int price = prices[i];

            if (price < buyPrice) {
                if (i > buyIndex) {
                    buyIndex = i;
                    buyPrice = price;

                    sellPrice = Integer.MIN_VALUE;
                }
            } else if ((price > buyPrice) && (price > sellPrice)) {
                sellPrice = price;

                int newMatched = sellPrice - buyPrice;
                if (newMatched > matchedBuy) {
                    matchedBuy = newMatched;
                }
            }
        }

        return matchedBuy;
    }
}
// @lc code=end

