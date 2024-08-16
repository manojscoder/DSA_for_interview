# Problem link: https://leetcode.com/problems/min-cost-to-connect-all-points/description/
# Time: O(n ^ 2 log E)
# Space: O(n)
class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        cost, size = 0, len(points)
        visit = [0] * size
        minHeap = [(0, 0)]

        while minHeap:
            cst, node = heapq.heappop(minHeap)

            if visit[node]:
                continue
            
            cost += cst
            visit[node] = 1

            for idx in range(len(points)):
                if visit[idx] != 1:
                    dist = abs(points[node][0] - points[idx][0]) + abs(points[node][1] - points[idx][1])
                    heapq.heappush(minHeap, (dist, idx))

        return cost
