# Problem link: https://leetcode.com/problems/coin-change/description/

# Top-down approach
# Time: O(amount * n)
# Space: O(amount)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        cache = {}
        
        def dfs(amt):
            if amt < 0:
                return amount + 1
            elif amt in cache:
                return cache[amt]
            elif amt == 0:
                return 0
            
            res = amount + 1
            for coin in coins:
                res = min(res, 1 + dfs(amt - coin))
            
            cache[amt] = res
            return res
        
        result = dfs(amount)
        return result if result != amount + 1 else -1

  # Bottom-up approach
  # Time: O(amount * n)
  # Space: O(amount)
  class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0

        for i in range(1, amount + 1):
            for c in coins:
                if c <= i:
                    dp[i] = min(dp[i], 1 + dp[i - c])
        
        return dp[amount] if dp[amount] != amount + 1 else -1
