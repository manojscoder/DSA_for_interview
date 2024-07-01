# Problem link: https://leetcode.com/problems/path-with-maximum-probability/description/
# Time: O(E log V)
# Space: O(E)
class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start_node: int, end_node: int) -> float:
        adjList = {}

        for edge, prob in zip(edges, succProb):
            u, v = edge

            if u not in adjList:
                adjList[u] = []
            
            if v not in adjList:
                adjList[v] = []
            
            adjList[u].append([v, prob])
            adjList[v].append([u, prob])
        
        maxHeap = [(-1, start_node)]
        visit = set()

        while maxHeap:
            prob, node = heapq.heappop(maxHeap)
            visit.add(node)

            if node == end_node:
                return prob * -1

            if node in adjList:
                for nei, edgeProb in adjList[node]:
                    if nei not in visit:
                        heapq.heappush(maxHeap, (edgeProb * prob, nei))
        
        return 0
