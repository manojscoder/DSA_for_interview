# Approach 1: Priority Queue (Heap)
# Time: O((V + E) * log v)
# Space: O(V + E)
class Solution:
    def shortestPath(self, n: int, edges: List[List[int]], src: int) -> Dict[int, int]:
        adjList = {}

        for i in range(n):
            adjList[i] = {}

        for u, v, d in edges:
            adjList[u][v] = d
        
        minHeap = [(0, src)]
        result = {}

        while minHeap:
            dist, node = heapq.heappop(minHeap)

            if node not in result:
                result[node] = dist

                for v, d in adjList[node].items():
                    if v not in result:
                        heapq.heappush(minHeap, (dist + d, v))
        
        for i in range(n):
            if i not in result:
                result[i] = -1
        
        return result
