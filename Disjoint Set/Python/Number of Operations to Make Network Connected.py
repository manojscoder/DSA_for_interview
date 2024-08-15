# Problem link: https://leetcode.com/problems/number-of-operations-to-make-network-connected/
# Time: O(V + E)
# Space: O(V + E)
class DS:
    def __init__(self, num):
        self.size = [1] * num
        self.parent = [index for index in range(num)]
    
    def find(self, node):
        if node == self.parent[node]:
            return node
        self.parent[node] = self.find(self.parent[node])
        return self.parent[node]
    
    def union(self, nodeOne, nodeTwo):
        parentOne, parentTwo = self.find(nodeOne), self.find(nodeTwo)

        if parentOne != parentTwo:
            if self.size[parentTwo] > self.size[parentOne]:
                self.size[parentTwo] += self.size[parentOne]
                self.parent[parentOne] = parentTwo
            else:
                self.size[parentOne] += self.size[parentTwo]
                self.parent[parentTwo] = parentOne

class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        if len(connections) < n - 1:
            return -1

        store = DS(n)

        for edge in connections:
            if store.find(edge[0]) != store.find(edge[1]):
                store.union(edge[0], edge[1])

        for node in range(n):
            store.find(node)
        
        return len(set(store.parent)) - 1
