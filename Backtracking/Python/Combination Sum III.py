# Problem link: https://leetcode.com/problems/combination-sum-iii/
# Time: O(9 ^ k)
# Space: O(k)
class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        result = []

        for num in range(1, 10):
            self.backTrack(num, num, k, n, result, [num])

        return result
    
    def backTrack(self, num, total, k, n, result, curr):
        if total == n and len(curr) == k:
            result.append(curr.copy())
            return
        
        for nxt in range(num + 1, 10):
            if total + nxt > n:
                break

            curr.append(nxt)
            self.backTrack(nxt, total + nxt, k, n, result, curr)
            curr.pop()
