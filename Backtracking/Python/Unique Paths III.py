# Problem link: https://leetcode.com/problems/unique-paths-iii/description/
# Time: O(4 ^ m * n)
# Space: O(m * n)
class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        count = 1

        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == 1:
                    start = (row, col)
                elif grid[row][col] == 2:
                    end = (row, col)
                elif not grid[row][col]:
                    count += 1
        
        return self.dfs(grid, start, end, count)
    
    def dfs(self, grid, st, ed, count):
        if st[0] < 0 or st[1] < 0 or st[0] == len(grid) or st[1] == len(grid[0]) or grid[st[0]][st[1]] == -1:
            return 0
        elif st == ed:
            return 1 if not count else 0
        
        grid[st[0]][st[1]] = -1

        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        total = 0

        for x, y in directions:
            total += self.dfs(grid, (st[0] + x, st[1] + y), ed, count - 1)
        
        grid[st[0]][st[1]] = 0
        
        return total

