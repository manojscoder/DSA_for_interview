# Problem link: https://leetcode.com/problems/rank-transform-of-an-array/description
# Time: O(n log n)
# Space: O(n)
class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        mapping, result, store, rank = {}, [], sorted(set(arr)), 1

        for num in store:
            mapping[num] = rank
            rank += 1
        
        for num in arr:
            result.append(mapping[num])
        
        return result
