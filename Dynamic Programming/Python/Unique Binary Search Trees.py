# Problem link: https://leetcode.com/problems/unique-binary-search-trees/description/
# Time: O(n ^ 2)
# Space: O(n)
class Solution:
    def numTrees(self, n: int) -> int:
        if n < 3:
            return n
        
        return self.DP(n, [0] * (n + 1))
    
    def DP(self, n, cache):
        if n <= 1:
            return 1
        elif cache[n] != 0:
            return cache[n]
        
        result = 0

        for i in range(1, n + 1):
            result += self.DP(i - 1, cache) * self.DP(n - i, cache)
        
        cache[n] = result
        return result
