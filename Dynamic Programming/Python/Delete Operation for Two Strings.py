# Problem link: https://leetcode.com/problems/delete-operation-for-two-strings/description/
# Time: O(m * n)
# Space: O(n)
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        rows, cols = len(word1), len(word2)
        prev, curr = [val for val in range(cols, -1, -1)], [0] * (cols + 1)
        
        for row in range(rows - 1, -1, -1):
            curr[-1] = rows - row

            for col in range(cols - 1, -1, -1):
                if word1[row] == word2[col]:
                    curr[col] = prev[col + 1]
                else:
                    curr[col] = 1 + min(prev[col], curr[col + 1])
            
            for index in range(cols + 1):
                prev[index] = curr[index]

        return prev[0]
