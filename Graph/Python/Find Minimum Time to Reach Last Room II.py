# Problem link: https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/description/
# Time: O(n * m * log(n * m))
# Space: O(n * m)
class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        rows, cols, PQ = len(moveTime), len(moveTime[0]), []
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        distance = [[float('inf')] * cols for _ in range(rows)]

        distance[0][0] = 0
        heappush(PQ, (0, 0, 0, 1))

        while PQ:
            dist, row, col, time = heappop(PQ)

            if dist > distance[row][col]:
                continue
            elif row == rows - 1 and col == cols - 1:
                return dist
            
            for dr, dc in directions:
                rw, cl = row + dr, col + dc
                
                if 0 <= rw < rows and 0 <= cl < cols and distance[rw][cl] > max(moveTime[rw][cl], dist) + time:
                    distance[rw][cl] = max(moveTime[rw][cl], dist) + time
                    heappush(PQ, (distance[rw][cl], rw, cl, time + (-1 if time == 2 else 1)))
        
        return distance[rows - 1][cols - 1]
