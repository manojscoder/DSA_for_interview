# Problem: https://leetcode.com/problems/implement-trie-prefix-tree/description/
# Time: O(n)
# Space: O(n)
class TrieNode:

    def __init__(self):
        self.store = [None] * 26
        self.isEnd = False

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root

        for char in word:
            if not node.store[ord(char) - ord('a')]:
                node.store[ord(char) - ord('a')] = TrieNode()
            node = node.store[ord(char) - ord('a')]
        
        node.isEnd = True
                
    def search(self, word: str) -> bool:
        node = self.root

        for char in word:
            if not node.store[ord(char) - ord('a')]:
                return False
            node = node.store[ord(char) - ord('a')]
        
        return node.isEnd

    def startsWith(self, prefix: str) -> bool:
        node = self.root

        for char in prefix:
            if not node.store[ord(char) - ord('a')]:
                return False
            node = node.store[ord(char) - ord('a')]
        
        return True
# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
