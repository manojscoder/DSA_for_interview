# Problem link: https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/description
# Time: O(V + E log V)
# Space: O(V + E + q)
class Solution:
    def shortestDistanceAfterQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        result = []
        adjList = [[node + 1] for node in range(n)]

        for a, b in queries:
            adjList[a].append(b)
            result.append(self.BFS(0, adjList, n))
        
        return result
    
    def BFS(self, src, adjList, num):
        distance = [float('inf')] * num
        distance[src], heap = 0, [(0, src)]

        while heap:
            dist, node = heappop(heap)

            if node == num - 1:
                return dist
            
            for nei in adjList[node]:
                if distance[nei] > dist + 1:
                    distance[nei] = dist + 1
                    heappush(heap, (dist + 1, nei))
        
        return -1
