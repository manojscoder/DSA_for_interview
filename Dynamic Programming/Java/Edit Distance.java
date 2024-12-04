// Problem link: https://leetcode.com/problems/edit-distance/description/
// Time: O(n * m)
// Space: O(m)
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        rows, cols = len(word1), len(word2)
        prev = [val for val in range(cols, -1, -1)]
        curr = [0] * (cols + 1)
        
        for row in range(rows - 1, -1, -1):
            curr[-1] = rows - row

            for col in range(cols - 1, -1, -1):
                if word1[row] == word2[col]:
                    curr[col] = prev[col + 1]
                else:
                    curr[col] = 1 + min(curr[col + 1], prev[col], prev[col + 1])
            
            for index in range(cols + 1):
                prev[index] = curr[index]
        
        return prev[0]
