# Problem link: https://leetcode.com/problems/find-if-path-exists-in-graph/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        size, parent = [1] * n, [node for node in range(n)]

        for u, v in edges:
            self.union(size, parent, u, v)
        
        return self.find(parent, source) == self.find(parent, destination)
    
    def find(self, parent, node):
        if node == parent[node]:
            return node
        parent[node] = self.find(parent, parent[node])
        return parent[node]
    
    def union(self, size, parent, nodeOne, nodeTwo):
        parentOne, parentTwo = self.find(parent, nodeOne), self.find(parent, nodeTwo)

        if parentOne != parentTwo:
            if size[parentTwo] > size[parentOne]:
                size[parentTwo] += size[parentOne]
                parent[parentOne] = parentTwo
            else:
                size[parentOne] += size[parentTwo]
                parent[parentTwo] = parentOne
