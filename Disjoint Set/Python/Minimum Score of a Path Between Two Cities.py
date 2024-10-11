# Problem link: https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def minScore(self, n: int, roads: List[List[int]]) -> int:
        parent = [node for node in range(n + 1)]
        size, result = [1] * (n + 1), float('inf')

        for u, v, w in roads:
            self.union(parent, size, u, v)

        for u, v, w in roads:
            if self.find(parent, 1) == self.find(parent, u):
                result = min(result, w)
            
        return result
    
    def find(self, parent, node):
        if parent[node] == node:
            return node
        parent[node] = self.find(parent, parent[node])
        return parent[node]
    
    def union(self, parent, size, nodeOne, nodeTwo):
        parOne, parTwo = self.find(parent, nodeOne), self.find(parent, nodeTwo)

        if parOne != parTwo:
            if size[parOne] < size[parTwo]:
                parent[parOne] = parTwo
                size[parTwo] += size[parOne]
            else:
                parent[parTwo] = parOne
                size[parOne] += size[parTwo] 
