# Time: O(E log E)
# Space: O(E)
class DS:
    
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
        
        if parentOne != parentTwo:
            if self.rank[parentOne] > self.rank[parentTwo]:
                self.parent[parentTwo] = parentOne
            elif self.rank[parentOne] < self.rank[parentTwo]:
                self.parent[parentOne] = parentTwo
            else:
                self.rank[parentOne] += 1
                self.parent[parentTwo] = parentOne
    

def kruskals(edges, num):
    store = DS(num)
    edges.sort(key = lambda x : x[2])
    
    cost, mstEdges = 0, []
    
    for nodeOne, nodeTwo, weight in edges:
        if store.find(nodeOne) != store.find(nodeTwo):
            store.union(nodeOne, nodeTwo)
            mstEdges.append([nodeOne, nodeTwo])
            cost += weight
    
    print(cost)
    print(mstEdges)

edges = [[0, 1, 2], [0, 2, 1], [1, 2, 1], [2, 4, 2], [3, 2, 2], [4, 3, 1]]
kruskals(edges, 5)
