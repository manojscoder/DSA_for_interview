# Problem link: https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description
# Time: O(N * L)
# Space: O(N * L)
class TrieNode:
    def __init__(self):
        self.store = {}
        self.isEnd = False

class Trie:

    def __init__(self):
        self.root = TrieNode()
    
    def add(self, folder):
        node = self.root

        for fold in folder:
            if fold not in node.store:
                node.store[fold] = TrieNode()
            
            node = node.store[fold]
        
        node.isEnd = True
    
    def search(self, folder):
        node = self.root

        for fold in folder:
            if node.isEnd:
                return False
            
            node = node.store[fold]

        return True


class Solution:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        trie = Trie()

        for fold in folder:
            trie.add(fold.split('/'))
        
        result = []

        for fold in folder:
            if trie.search(fold.split('/')):
                result.append(fold)
            
        return result
