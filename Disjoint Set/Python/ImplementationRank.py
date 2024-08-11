# Time: O(4 alpha)
class disjointSet:
    
    def __init__(self, num):
        self.rank = [0] * (num + 1)
        self.ultimateParent = [index for index in range(num + 1)]
        
    
    def findParent(self, node):
        if node == self.ultimateParent[node]:
            return node
        self.ultimateParent[node] = self.findParent(self.ultimateParent[node])
        return self.ultimateParent[node]
    
    
    def unionByRank(self, nodeOne, nodeTwo):
        parentOne, parentTwo = self.findParent(nodeOne), self.findParent(nodeTwo)
        
        if parentOne == parentTwo:
            return
            
        rankOne, rankTwo = self.rank[parentOne], self.rank[parentTwo]
        
        if rankOne < rankTwo:
            self.ultimateParent[parentOne] = parentTwo
        elif rankOne > rankTwo:
            self.ultimateParent[parentTwo] = parentOne
        else:
            self.ultimateParent[parentTwo] = parentOne
            self.rank[parentOne] += 1
            

ds = disjointSet(7)
edges = [[1, 2], [2, 3], [4, 5], [6, 7], [5, 6]]

for one, two in edges:
    ds.unionByRank(one, two)
    
if ds.findParent(3) == ds.findParent(7):
    print("Both are in same component")
else:
    print("Both are not in same component")

ds.unionByRank(3, 7)

if ds.findParent(3) == ds.findParent(7):
    print("Both are in same component")
else:
    print("Both are not in same component")
