# Problem link: https://leetcode.com/problems/unique-paths-ii/description/

# Approach 1: Brute force (TLE)
# Time: O(2 ^ (m + n))
# Space: O(m + n)
class Solution:
    def uniquePathsWithObstacles(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        
        def dfs(r, c):
            if r >= m or c >= n or grid[r][c] == 1:
                return 0
            elif r == m - 1 and c == n - 1:
                return 1
            
            return dfs(r + 1, c) + dfs(r, c + 1)

        return dfs(0 , 0)


# Approach 2: Top-down DP
# Time: O(m * n)
# Space: O(m * n)
class Solution:
    def uniquePathsWithObstacles(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        cache = {}
        
        def dfs(r, c):
            if r >= m or c >= n or grid[r][c] == 1:
                return 0
            elif (r, c) in cache:
                return cache[(r, c)]
            elif r == m - 1 and c == n - 1:
                return 1
            
            cache[(r, c)] = dfs(r + 1, c) + dfs(r, c + 1)
            return cache[(r, c)]

        return dfs(0 , 0)

# Approach 3: Bottom-up DP
# Time: O(m * n)
# Space: O(m * n)
class Solution:
    def uniquePathsWithObstacles(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        if grid[m - 1][n - 1]:
            return 0

        DP = [[0] * n for _ in range(m)]
        DP[m - 1][n - 1] = 1

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if grid[i][j] != 1:
                    if j + 1 < n:
                        DP[i][j] += DP[i][j + 1]
                    if i + 1 < m:
                        DP[i][j] += DP[i + 1][j]
        
        return DP[0][0]

# Approach 4: Space optimized DP
# Time: O(m * n)
# Space: O(n)
class Solution:
    def uniquePathsWithObstacles(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        if grid[m - 1][n - 1]:
            return 0

        DP = [0] * n
        DP[n - 1] = 1

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if grid[i][j] != 1:
                    if j + 1 < n:
                        DP[j] += DP[j + 1]
                else:
                    DP[j] = 0
    
        return DP[0]
