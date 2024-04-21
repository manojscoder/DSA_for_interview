// Time: O(n)
// Space: O(1)
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution {
    public int maxProfit(int[] prices) {
        int result = 0, buy = prices[0];

        for(int i = 1; i < prices.length; i++){
            result = Math.max(result, prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }
        return result;
    }
}
