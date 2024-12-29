# Problem link: https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/description
# Time: O(n * w + m * w)
# Space: O(m * w)
class Solution:
    def numWays(self, words: List[str], target: str) -> int:
        targetSize, wordSize = len(target), len(words[0])
        countChar = [[0] * 26 for _ in range(wordSize)]
        DP = [[0] * (wordSize + 1) for _ in range(targetSize + 1)]

        for word in words:
            for index, char in enumerate(word):
                countChar[index][ord(char) - ord('a')] += 1
        
        for k in range(wordSize + 1):
            DP[targetSize][k] = 1

        for tIndex in range(targetSize - 1, -1, -1):
            for wIndex in range(wordSize - 1, -1, -1):
                DP[tIndex][wIndex] = DP[tIndex][wIndex + 1]
                char = target[tIndex]
                DP[tIndex][wIndex] += countChar[wIndex][ord(char) - ord('a')] * DP[tIndex + 1][wIndex + 1]
                DP[tIndex][wIndex] %= 10 ** 9 + 7
        
        return DP[0][0]
