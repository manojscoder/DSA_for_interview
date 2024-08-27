# Problem link: https://leetcode.com/problems/longest-palindromic-subsequence/description/

# Approach: Brute force(TLE)
class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        return self.LCS(s, len(s) - 1, len(s) - 1)
    
    def LCS(self, s, idxOne, idxTwo):
        if idxOne < 0 or idxTwo < 0:
            return 0
        elif s[idxOne] == s[len(s) - idxTwo - 1]:
            return 1 + self.LCS(s, idxOne - 1, idxTwo - 1)

        return max(self.LCS(s, idxOne - 1, idxTwo), self.LCS(s, idxOne, idxTwo - 1))

# Approach: Top-down 
# Time: O(n * n)
# Space: O(n * n)
class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        DP = [[-1] * len(s) for _ in range(len(s))]
        return self.LCS(s, len(s) - 1, len(s) - 1, DP)
    
    def LCS(self, s, idxOne, idxTwo, DP):
        if idxOne < 0 or idxTwo < 0:
            return 0
        elif DP[idxOne][idxTwo] != -1:
            return DP[idxOne][idxTwo]
        elif s[idxOne] == s[len(s) - idxTwo - 1]:
            DP[idxOne][idxTwo] = 1 + self.LCS(s, idxOne - 1, idxTwo - 1, DP)
        else:
            DP[idxOne][idxTwo] = max(self.LCS(s, idxOne - 1, idxTwo, DP), self.LCS(s, idxOne, idxTwo - 1, DP))
        return DP[idxOne][idxTwo]

# Approach: Bottom-up
# Time: O(n * n)
# Space: O(n * n)
class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        rows, cols = len(s), len(s)
        DP = [[0] * (cols + 1) for _ in range(rows + 1)]

        for row in range(rows - 1, -1, -1):
            for col in range(cols - 1, -1, -1):
                if s[row] == s[cols - col - 1]:
                    DP[row][col] = 1 + DP[row + 1][col + 1]
                else:
                    DP[row][col] = max(DP[row + 1][col], DP[row][col + 1])

        return DP[0][0]

# Approach: Space optimized
# Time: O(n * n)
# Space: O(n)
class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        prev = [0] * (len(s) + 1)
        curr = [0] * (len(s) + 1)

        for row in range(len(s) - 1, -1, -1):
            for col in range(len(s) - 1, -1, -1):
                if s[row] == s[len(s) - col - 1]:
                    curr[col] = 1 + prev[col + 1]
                else:
                    curr[col] = max(curr[col + 1], prev[col])
            prev, curr = curr, prev

        return prev[0]
