# Problem link: https://www.geeksforgeeks.org/problems/construct-binary-tree-from-parent-array/1
# Time: O(n)
# Space: O(n) 

class Solution:
    def createTree(self,parent):
        store = {}
        root = -1
        
        for i in range(len(parent)):
            if parent[i] not in store:
                store[parent[i]] = Node(parent[i])
            
            if i not in store:
                store[i] = Node(i)
            
            if parent[i] == -1:
                root = i
            else:
                if not store[parent[i]].left:
                    store[parent[i]].left = store[i]
                else:
                    store[parent[i]].right = store[i]
                    
        return store[root]
