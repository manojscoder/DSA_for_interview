# Problem link: https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description
# Time: O(n + m)
# Space: O(m)
class TrieNode:

    def __init__(self):
        self.store = [None] * 10
        self.isEnd = False

class Trie:

    def __init__(self):
        self.root = TrieNode()
    
    def addWord(self, word):
        node = self.root

        for char in word:
            if not node.store[ord(char) - ord('0')]:
                node.store[ord(char) - ord('0')] = TrieNode()
            node = node.store[ord(char) - ord('0')]
        
        node.isEnd = True
    
    def findLongestPrefix(self, word):
        count, node = 0, self.root

        for char in word:
            if not node.store[ord(char) - ord('0')]:
                return count
            count += 1
            node = node.store[ord(char) - ord('0')]
        
        return count

class Solution:
    def longestCommonPrefix(self, arr1: List[int], arr2: List[int]) -> int:
        trie, result = Trie(), 0

        for num in arr1:
            trie.addWord(str(num))
        
        for num in arr2:
            result = max(result, trie.findLongestPrefix(str(num)))
        
        return result
