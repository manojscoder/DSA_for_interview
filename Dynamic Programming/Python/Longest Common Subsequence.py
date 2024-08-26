# Problem link:https://leetcode.com/problems/longest-common-subsequence/description/

# Approach: Brute force(TLE)
class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        return self.LCS(text1, text2, 0, 0)
    
    def LCS(self, text1, text2, idxOne, idxTwo):
        if idxOne == len(text1) or idxTwo == len(text2):
            return 0
        elif text1[idxOne] == text2[idxTwo]:
            return 1 + self.LCS(text1, text2, idxOne + 1, idxTwo + 1)
        return max(self.LCS(text1, text2, idxOne + 1, idxTwo), self.LCS(text1, text2, idxOne, idxTwo + 1))

# Approach: Top-down
# Time: O(n * m)
# Space: O(n * m)
class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        DP = [[-1 for _ in range(len(text2))] for _ in range(len(text1))]
        return self.LCS(text1, text2, 0, 0, DP)

    def LCS(self, text1: str, text2: str, idxOne: int, idxTwo: int, DP: list) -> int:
        if idxOne == len(text1) or idxTwo == len(text2):
            return 0
        elif DP[idxOne][idxTwo] != -1:
            return DP[idxOne][idxTwo]
        elif text1[idxOne] == text2[idxTwo]:
            DP[idxOne][idxTwo] = 1 + self.LCS(text1, text2, idxOne + 1, idxTwo + 1, DP)
        else:
            DP[idxOne][idxTwo] = max(self.LCS(text1, text2, idxOne + 1, idxTwo, DP), self.LCS(text1, text2, idxOne, idxTwo + 1, DP))
        
        return DP[idxOne][idxTwo]

# Approach: Bottom-Up
# Time: O(n * m)
# Space: O(n * m)
class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        rows, cols = len(text1), len(text2)
        DP = [[0] * (cols + 1) for _ in range(rows + 1)]

        for row in range(rows - 1, -1, -1):
            for col in range(cols - 1, -1, -1):
                if text1[row] == text2[col]:
                    DP[row][col] = 1 + DP[row + 1][col + 1]
                else:
                    DP[row][col] = max(DP[row + 1][col], DP[row][col + 1])
        
        return DP[0][0]

# Approach: Space Optimized
# Time: O(n * m)
# Space: O(m)
class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        rows, cols = len(text1), len(text2)
        prev = [0] * (cols + 1)
        curr = [0] * (cols + 1)

        for row in range(rows - 1, -1, -1):
            for col in range(cols - 1, -1, -1):
                if text1[row] == text2[col]:
                    curr[col] = 1 + prev[col + 1]
                else:
                    curr[col] = max(curr[col + 1], prev[col])
            
            curr, prev = prev, curr
        
        return prev[0]
