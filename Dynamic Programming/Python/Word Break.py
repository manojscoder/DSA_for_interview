# Problem link: https://leetcode.com/problems/word-break/description/
# Time: O(n * w) where w is the length of wordDict
# Space: O(n)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        cache = {}

        def dfs(word):
            if not word:
                return True
            elif word in cache:
                return cache[word]
            
            for strsub in wordDict:
                if strsub == word[ : len(strsub)]:
                    if dfs(word[len(strsub) : ]):
                        cache[word] = True
                        return True
            
            cache[word] = False
            return False
        
        return dfs(s)
