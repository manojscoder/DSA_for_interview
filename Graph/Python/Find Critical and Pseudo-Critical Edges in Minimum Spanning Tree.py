# Problem link: https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/description/
# Time: O(e ^ 2 * log(v))
# Space: O(e * v)
class UnionFind:

    def __init__(self, num):
        self.parent = [node for node in range(num)]
        self.size = [1] * num
    
    def find(self, node):
        if self.parent[node] == node:
            return node
        self.parent[node] = self.find(self.parent[node])
        return self.parent[node]
    
    def union(self, nodeOne, nodeTwo):
        parentOne, parentTwo = self.find(nodeOne), self.find(nodeTwo)

        if parentOne != parentTwo:

            if self.size[parentOne] < self.size[parentTwo]:
                self.size[parentTwo] += self.size[parentOne]
                self.parent[parentOne] = parentTwo
            else:
                self.size[parentOne] += self.size[parentTwo]
                self.parent[parentTwo] = parentOne


class Solution:
    def findCriticalAndPseudoCriticalEdges(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        for index, edge in enumerate(edges):
            edge.append(index)          
        
        edges.sort(key = lambda x : x[2])
        unionFind, mstWeight = UnionFind(n), 0

        for ver1, ver2, wei, idx in edges:
            if unionFind.find(ver1) != unionFind.find(ver2):
                unionFind.union(ver1, ver2)
                mstWeight += wei
        
        critical, pseudo = [], []

        for ver1, ver2, wei, idx in edges:
            criticalUF, CWeight = UnionFind(n), 0
            pseudoUF, PCWeight = UnionFind(n), wei
            pseudoUF.union(ver1, ver2)

            for v1, v2, weight, index in edges:
                if index != idx and criticalUF.find(v1) != criticalUF.find(v2):
                    criticalUF.union(v1, v2)
                    CWeight += weight

                if pseudoUF.find(v1) != pseudoUF.find(v2):
                    pseudoUF.union(v1, v2)
                    PCWeight += weight
            
            if CWeight != mstWeight:
                critical.append(idx)
            elif PCWeight == mstWeight:
                pseudo.append(idx)

        return [critical, pseudo]
