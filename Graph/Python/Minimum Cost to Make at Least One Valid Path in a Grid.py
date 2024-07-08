# Problem link: https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/
# Time: O(n * m * log(n * m))
# Space: O(n * m)
class Solution:
    def minCost(self, grid: List[List[int]]) -> int:
        minHeap, visit = [(0, 0, 0)], set()
        rows, cols = len(grid), len(grid[0])
        direction = [[1, 0], [0, 1], [-1, 0], [0, -1]]

        while minHeap:
            cost, row, col = heapq.heappop(minHeap)

            if (row, col) in visit:
                continue
            
            if row == rows - 1 and col == cols - 1:
                return cost
            
            visit.add((row, col))

            if grid[row][col] == 1:
                rw, cl = row, col + 1
            elif grid[row][col] == 2:
                rw, cl = row, col - 1
            elif grid[row][col] == 3:
                rw, cl = row + 1, col
            else:
                rw, cl = row - 1, col

            for r, c in direction:
                if r + row >= 0 and r + row < rows and c + col >= 0 and c + col < cols:
                    if r + row == rw and c + col == cl:
                        heapq.heappush(minHeap, (cost, r + row, c + col))
                    else:
                        heapq.heappush(minHeap, (cost + 1, r + row, c + col))
        
        return -1
