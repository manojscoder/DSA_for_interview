# Problem link: https://leetcode.com/problems/climbing-stairs/description/

# Top-down approach
# Time: O(n)
# Space: O(n)
class Solution:
    def climbStairs(self, n: int) -> int:
        cache = {n : 1}

        def count(step):
            if step > n:
                return 0
            elif step in cache:
                return cache[step]
            
            cache[step] = count(step + 1) + count(step + 2)
            return cache[step]
        
        return count(0)

# Bottom-up approach
# Time: O(n)
# Space: O(n)
class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n

        dp = [0] * (n + 1)
        dp[n] = dp[n - 1] = 1

        for i in range(n - 2, -1, -1):
            dp[i] = dp[i + 1] + dp[i + 2]
        
        return dp[0]

# Space optimized
# Time: O(n)
# Space: O(1)
class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n

        one = two = 1

        for i in range(n - 2, -1, -1):
            one, two = one + two, one
        
        return one
            
