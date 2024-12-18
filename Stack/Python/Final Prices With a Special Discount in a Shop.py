# Problem link: https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        result, stack = prices[::], []

        for index in range(len(prices)):

            while stack and prices[stack[-1]] >= prices[index]:
                result[stack.pop()] -= prices[index]
            
            stack.append(index)
        
        return result
