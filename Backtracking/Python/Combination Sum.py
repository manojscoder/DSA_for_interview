# Problem link: https://leetcode.com/problems/combination-sum/description/
# Time: O(2 ^ n)
# Space: O(n)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result, curr = [], [] 
        self.backtrack(result, curr, candidates, target, 0)

        return result
    
    def backtrack(self, result, curr, candidates, target, index):
        if target == 0:
            result.append(curr.copy())
        if target <= 0:
            return
        
        for idx in range(index, len(candidates)):
            curr.append(candidates[idx])
            self.backtrack(result, curr, candidates, target - candidates[idx], idx)
            curr.pop()
