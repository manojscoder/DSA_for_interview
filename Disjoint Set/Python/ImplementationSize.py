# Time: O(4 alpha)
class disjointSetSize:
    
    def __init__(self, num):
        self.size = [1] * (num + 1)
        self.ultimateParent = [index for index in range(num + 1)]
    
    
    def findParent(self, node):
        if node == self.ultimateParent[node]:
            return node
        self.ultimateParent[node] = self.findParent(self.ultimateParent[node])
        return self.ultimateParent[node]
    
    def unionBySize(self, nodeOne, nodeTwo):
        parentOne, parentTwo = self.findParent(nodeOne), self.findParent(nodeTwo)
        
        if parentOne == parentTwo:
            return
    
        sizeOne, sizeTwo = self.size[parentOne], self.size[parentTwo]
        
        if sizeOne < sizeTwo:
            self.ultimateParent[parentOne] = parentTwo
            self.size[parentTwo] += sizeOne
        else:
            self.ultimateParent[parentTwo] = parentOne
            self.size[parentOne] += sizeTwo

ds = disjointSetSize(7)
edges = [[1, 2], [2, 3], [4, 5], [6, 7], [5, 6]]

for one, two in edges:
    ds.unionBySize(one, two)
    
if ds.findParent(3) == ds.findParent(7):
    print("Both are in same component")
else:
    print("Both are not in same component")

ds.unionBySize(3, 7)

if ds.findParent(3) == ds.findParent(7):
    print("Both are in same component")
else:
    print("Both are not in same component")
        
