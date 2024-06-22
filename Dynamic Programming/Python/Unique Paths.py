# Problem link: https://leetcode.com/problems/unique-paths/description/

# Approach 1: Brute force(TLE)
# Time: O(2 ^ (m + n))
# Sace: O(m + n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        def dfs(r, c):
            if r >= m or c >= n:
                return 0
            elif r == m - 1 and c == n - 1:
                return 1
            
            return dfs(r + 1, c) + dfs(r, c + 1)
        
        return dfs(0, 0)

# Approach 2: Top-down DP
# Time: O(m * n)
# Space: O(m * n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        cache = {}

        def dfs(r, c):
            if r >= m or c >= n:
                return 0
            elif (r, c) in cache:
                return cache[(r, c)]
            elif r == m - 1 and c == n - 1:
                return 1
            
            cache[(r, c)] = dfs(r + 1, c) + dfs(r, c + 1)
            return cache[(r, c)]
        
        return dfs(0, 0)

# Approach 3: Bottom-up DP
# Time: O(m * n)
# Space: O(m * n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0] * n for _ in range(m)]

        dp[m - 1][n - 1] = 1

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if j + 1 < n:
                    dp[i][j] += dp[i][j + 1]
                if i + 1 < m:
                    dp[i][j] += dp[i + 1][j]
        
        return dp[0][0]


# Approach 4: Space optimized DP
# Time: O(m * n)
# Space: O(n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [0] * n
        dp[n - 1] = 1

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if j + 1 < n:
                    dp[j] += dp[j + 1]
        
        return dp[0]

