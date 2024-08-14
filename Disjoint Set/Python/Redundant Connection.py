# Problem link: https://leetcode.com/problems/redundant-connection/description/
# Time: O(n)
# Space: O(n)
class disjointSet:

    def __init__(self, num):
        self.rank = [0] * (num + 1)
        self.parent = [index for index in range(num + 1)]

    def find(self, node):
        if node == self.parent[node]:
            return node
        self.parent[node] = self.find(self.parent[node])
        return self.parent[node]
    
    def union(self, nodeOne, nodeTwo):
        parentOne, parentTwo = self.find(nodeOne), self.find(nodeTwo)

        if parentOne == parentTwo:
            return
        
        rankOne, rankTwo = self.rank[parentOne], self.rank[parentTwo]

        if rankOne > rankTwo:
            self.parent[parentTwo] = parentOne
        elif rankOne < rankTwo:
            self.parent[parentOne] = parentTwo
        else:
            self.rank[parentOne] += 1
            self.parent[parentTwo] = parentOne

class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        DS = disjointSet(len(edges))
        result = 0

        for index, (u, v) in enumerate(edges):
            if DS.find(u) == DS.find(v):
                result = index
            DS.union(u, v)
        
        return edges[result]
