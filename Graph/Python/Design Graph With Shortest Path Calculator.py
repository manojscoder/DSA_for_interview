# Problem link: https://leetcode.com/problems/design-graph-with-shortest-path-calculator/
# Time: O(V + E * log V)
# Space: O(V + E)
class Graph:
    def __init__(self, n, edges):
        self.adjList = defaultdict(list)
        self.numV = n
        for edge in edges:
            self.adjList[edge[0]].append((edge[1], edge[2]))

    def addEdge(self, edge):
        self.adjList[edge[0]].append((edge[1], edge[2]))

    def shortestPath(self, src, des):
        dist = [float('inf')] * self.numV
        dist[src] = 0
        minHeap = [(0, src)]
        visited = [False] * (self.numV + 1)

        while minHeap:
            curr_dist, u = heapq.heappop(minHeap)
            if visited[u]:
                continue

            if u == des:
                return curr_dist

            visited[u] = True

            for v, weight in self.adjList[u]:
                if dist[v] > curr_dist + weight:
                    dist[v] = curr_dist + weight
                    heapq.heappush(minHeap, (dist[v], v))

        return -1
