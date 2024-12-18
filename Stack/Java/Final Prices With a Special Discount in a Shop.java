// Problem link: https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/
// Time: O(n)
// Space: O(n)
class Solution {
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for(int index = 0; index < prices.length; index++) {
            result[index] = prices[index];
        }

        for(int index = 0; index < prices.length; index++) {

            while(!stack.isEmpty() && prices[stack.peek()] >= prices[index]) {
                result[stack.pop()] -= prices[index];
            }

            stack.push(index);
        }

        return result;
    }
}
