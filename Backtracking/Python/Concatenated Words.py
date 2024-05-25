# Problem link: https://leetcode.com/problems/concatenated-words/description/
# Time: O(n * L ^ 3), where L is the length of the word
# Space: O(n)
class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        wordsSet, cache = set(words), {}

        def dfs(word):
            if word in cache:
                return cache[word]

            for j in range(1, len(word)):
                prefix, suffix = word[ : j], word[j : ]
                if(prefix in wordsSet) and (suffix in wordsSet or dfs(suffix)):
                    cache[word] = True
                    return cache[word]

            cache[word] = False
            return cache[word]

        return [s for s in words if dfs(s)]
