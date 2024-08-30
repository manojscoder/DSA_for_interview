# Problem link: https://leetcode.com/problems/modify-graph-edge-weights/description
# Time: O(K * (V + E) * log V)
# Space: O(V + E)
class Solution:
    def modifiedGraphEdges(self, n: int, edges: List[List[int]], source: int, destination: int, target: int) -> List[List[int]]:
        adjList = [[] for _ in range(n)]

        for u, v, w in edges:
            if w != -1:
                adjList[u].append((v, w))
                adjList[v].append((u, w))
        
        shortDist = self.dijkstra(adjList, source, destination, n)

        if shortDist == target:

            for idx, (u, v, w) in enumerate(edges):
                if w == -1:
                    edges[idx][2] = target

            return edges
        elif shortDist > target:
            for idx, (u, v, w) in enumerate(edges):

                if w == -1:
                    edges[idx][2] = 1
                    adjList[u].append((v, 1))
                    adjList[v].append((u, 1))
                    dist = self.dijkstra(adjList, source, destination, n)

                    if dist <= target:
                        edges[idx][2] += target - dist 

                        for i in range(idx + 1, len(edges)):
                            if edges[i][2] == -1:
                                edges[i][2] = target

                        return edges

        return []


    def dijkstra(self, adjList, src, des, n):
        dist = [inf] * n
        minHeap, dist[src] = [(0, src)], 0

        while minHeap:
            wei, node = heapq.heappop(minHeap)

            for nei, neiWei in adjList[node]:
                if neiWei + wei < dist[nei]:
                    dist[nei] = neiWei + wei
                    heapq.heappush(minHeap, (dist[nei], nei))
        
        return dist[des]
