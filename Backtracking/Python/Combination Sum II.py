# Problem link: https://leetcode.com/problems/combination-sum-ii/description/
# Time: O(2 ^ n)
# Space: O(n) 
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        candidates.sort()

        def backTrack(target, curr, index):
            if target == 0:
                result.append(curr.copy())
            if target <= 0:
                return
            
            prev = -1
            for i in range(index, len(candidates)):
                if prev != candidates[i]:
                    curr.append(candidates[i])
                    backTrack(target - candidates[i], curr, i + 1)
                    curr.pop()
                    prev = candidates[i]

        backTrack(target, [], 0)
        return result
