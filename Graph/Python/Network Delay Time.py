# Problem link: https://leetcode.com/problems/network-delay-time/description/

# Approach 1: Dijkstras
# Time: O(E log V)
# Space: O(V + E)
class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adjList = {}

        for u, v, time in times:
            if u not in adjList:
                adjList[u] = []
            
            adjList[u].append([v, time])
        
        dist = [inf for _ in range(n + 1)]
        dist[k], minHeap, visit, result = 0, [(0, k)], set(), -1

        while minHeap:
            time, node = heapq.heappop(minHeap)
            if node in visit:
                continue
            visit.add(node)

            if node in adjList:
                for v, tym in adjList[node]:
                    if tym + time < dist[v]:
                        dist[v] = tym + time
                        heapq.heappush(minHeap, (dist[v], v))
        
        for i in range(1, len(dist)):
            if math.isinf(dist[i]):
                return -1
            result = max(result, dist[i])

        return result


# Approach 2: Bellman ford
# Time: O(E * V)
# Space: O(V)
class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        dist = [float('inf') for _ in range(n)]
        dist[k - 1], result = 0, -1

        for i in range(n - 1):
            for j in range(len(times)):
                u, v, t = times[j]

                if dist[u - 1] != float('inf') and dist[u - 1] + t < dist[v - 1]:
                    dist[v - 1] = dist[u - 1] + t

        for i in range(n):
            if dist[i] == float('inf'):
                return -1
            result = max(result, dist[i])

        return result
