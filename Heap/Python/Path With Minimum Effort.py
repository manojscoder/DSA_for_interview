# Problem link: https://leetcode.com/problems/path-with-minimum-effort/
# Time: O(m * n * log(m * n))
# Space: O(m * n)
class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        rows, cols = len(heights), len(heights[0])
        minHeap, visit, directions = [(0, 0, 0)], set(), [[1, 0], [0, 1], [-1, 0], [0, -1]]


        while minHeap:
            t, r, c = heapq.heappop(minHeap)

            if (r, c) in visit:
                continue

            if r == rows - 1 and c == cols - 1:
                return t
            
            visit.add((r, c))

            for row, col in directions:
                if not(row + r < 0 or row + r == rows or col + c < 0 or col + c == cols):
                    time = max(t, abs(heights[r][c] - heights[row + r][col + c]))
                    heapq.heappush(minHeap, (time, row + r, col + c))
        
        return -1
