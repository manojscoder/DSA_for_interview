# Problem link: https://leetcode.com/problems/minimum-path-sum/description/

# Approach 1: Brute force (TLE)
# Time: O(2 ^ (m + n))
# Space: O(m + n)
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        
        def dfs(r, c):
            if r >= m or c >= n:
                return inf
            elif r == m - 1 and c == n - 1:
                return grid[r][c]
            
            return grid[r][c] + min(dfs(r + 1, c), dfs(r, c + 1))
        
        return dfs(0, 0)


# Approach 2: Top-down DP
# Time: O(m * n)
# Space: O(m * n)
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        cache = {}
        
        def dfs(r, c):
            if r >= m or c >= n:
                return inf
            elif (r, c) in cache:
                return cache[(r, c)]
            elif r == m - 1 and c == n - 1:
                return grid[r][c]
            
            cache[(r, c)] = grid[r][c] + min(dfs(r + 1, c), dfs(r, c + 1))
            return cache[(r, c)]
        
        return dfs(0, 0)


# Approach 3: Bottom-up DP
# Time: O(m * n)
# Space: O(m * n)
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if j + 1 < n and i + 1 < m:
                    grid[i][j] += min(grid[i][j + 1], grid[i + 1][j])
                elif j + 1 < n:
                    grid[i][j] += grid[i][j + 1]
                elif i + 1 < m:
                    grid[i][j] += grid[i + 1][j]
        
        return grid[0][0]


# Approach 4: Space optimized DP
# Time: O(m * n)
# Space: O(n)
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        DP = [inf] * n
        DP[n - 1] = 0

        
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if j + 1 < n:
                    DP[j] = grid[i][j] + min(DP[j], DP[j + 1])
                else:
                    DP[j] += grid[i][j]
        
        return DP[0]
