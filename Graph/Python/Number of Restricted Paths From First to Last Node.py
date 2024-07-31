# Problem link: https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/description/
# Time: O((E + V) log V)
# Space: O(V + E)
class Solution:
    def countRestrictedPaths(self, n: int, edges: List[List[int]]) -> int:
        adjList = [[] for _ in range(n + 1)]

        for u, v, w in edges:
            adjList[u].append((v, w))
            adjList[v].append((u, w))

        minDistance = self.dijkstra(n, adjList, n)
        cache = [-1] * (n + 1)

        return self.dfs(adjList, float('inf'), 1, minDistance, cache) % (10 ** 9 + 7)

        
    def dfs(self, adjList, prev, node, minDistance, cache):
        if node == len(adjList) - 1:
            return 1
        elif prev <= minDistance[node]:
            return 0
        elif cache[node] != -1:
            return cache[node]
        
        cache[node] = 0
        for nei, wei in adjList[node]:
            cache[node] += self.dfs(adjList, minDistance[node], nei, minDistance, cache)
        
        return cache[node]
        

    def dijkstra(self, n, adjList, src):
        distance = [float('inf')] * (n + 1)
        heap, visited, distance[src] = [(0, src)], [0] * (n + 1), 0

        while heap:
            dist, node = heapq.heappop(heap)

            if visited[node]:
                continue
            
            visited[node] = 1

            for nei, wei in adjList[node]:
                if dist + wei < distance[nei]:
                    distance[nei] = dist + wei
                    heapq.heappush(heap, (distance[nei], nei))
        
        return distance
