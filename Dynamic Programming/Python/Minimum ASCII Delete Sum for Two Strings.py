# Problem link: https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
# Time: O(n * m)
# Space: O(m)
class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        rows, cols = len(s1), len(s2)
        prev, curr = [0] * (cols + 1), [0] * (cols + 1)

        for col in range(cols - 1, -1, -1):
            prev[col] = prev[col + 1] + ord(s2[col])
        
        for row in range(rows - 1, -1, -1):
            curr[cols] = prev[-1] + ord(s1[row])

            for col in range(cols - 1, -1, -1):
                if s1[row] == s2[col]:
                    curr[col] = prev[col + 1]
                else:
                    curr[col] = min(ord(s1[row]) + prev[col], ord(s2[col]) + curr[col + 1])
                
            for col in range(cols + 1):
                prev[col] = curr[col]
            
        return prev[0]
