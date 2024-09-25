# Problem link: https://leetcode.com/problems/sum-of-prefix-scores-of-strings/description
# Time: O(n * m)
# Space: O(n * m)
class TrieNode:

    def __init__(self):
        self.store = [None] * 26
        self.count = [0] * 26
        self.isEnd = False

class Trie:

    def __init__(self):
        self.root = TrieNode()
    
    def addWord(self, word):
        node = self.root

        for char in word:
            if not node.store[ord(char) - ord('a')]:
                node.store[ord(char) - ord('a')] = TrieNode()

            node.count[ord(char) - ord('a')] += 1
            node = node.store[ord(char) - ord('a')]
            
        
        node.isEnd = True
    
    def prefixCount(self, word):
        result = 0
        node = self.root

        for char in word:
            result += node.count[ord(char) - ord('a')]
            node = node.store[ord(char) - ord('a')]
        
        return result

class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        trie = Trie()
        result = []

        for word in words:
            trie.addWord(word)
        
        for word in words:
            result.append(trie.prefixCount(word))
        
        return result
