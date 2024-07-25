# Problem link: https://leetcode.com/problems/triangle/description

# Approach: 1 (Brute force) TLE
# Time: O(2 ^ n)
# Space: O(n)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        return self.dfs(0, 0, triangle)
    
    def dfs(self, row, col, tri):
        if row == len(tri) - 1:
            return tri[row][col]
            
        return tri[row][col] + min(self.dfs(row + 1, col, tri), self.dfs(row + 1, col + 1, tri))


# Approach: 2 (Top-Down) 
# Time: O(n ^ 2)
# Space: O(n ^ 2)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        return self.dfs(0, 0, {}, triangle)
    
    def dfs(self, row, col, cache, tri):
        if row == len(tri) - 1:
            return tri[row][col]
        elif (row, col) in cache:
            return cache[(row, col)]
            
        cache[(row, col)] = tri[row][col] + min(self.dfs(row + 1, col, cache, tri), self.dfs(row + 1, col + 1, cache, tri))

        return cache[(row, col)]


# Approach: 3 (Bottom-Up)
# Time: O(n ^ 2)
# Space: O(n ^ 2)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        rows = len(triangle)

        for row in range(rows - 2, -1, -1):
            for idx in range(len(triangle[row])):
                triangle[row][idx] += min(triangle[row + 1][idx], triangle[row + 1][idx + 1])
        
        return triangle[0][0]


# Approach: 4 (Space optimized)
# Time: O(n ^ 2)
# Space: O(n)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        DP = [0] * (len(triangle) + 1)

        for row in triangle[::-1]:
            for idx, val in enumerate(row):
                DP[idx] = val + min(DP[idx], DP[idx + 1])
            
        return DP[0]
