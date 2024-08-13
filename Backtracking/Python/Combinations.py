# Problem link: https://leetcode.com/problems/combinations/description/
# Time: O(2 ^ n)
# Space: O(n)
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        result, curr = [], []
        self.backtrack(result, curr, n, k, 1)

        return result
    
    def backtrack(self, result, curr, n, k, index):
        if len(curr) == k:
            result.append(curr.copy())
            return
        
        for idx in range(index, n + 1):
            curr.append(idx)
            self.backtrack(result, curr, n, k, idx + 1)
            curr.pop()
