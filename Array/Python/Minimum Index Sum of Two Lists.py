# problem link: https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
# Time: O(m + n)
# Space: O(n)
class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        store = {s: idx for idx, s in enumerate(list1)}
        minSum, result = float('inf'), []

        for idx in range(len(list2)):
            if list2[idx] in store:
                val = min(val, idx + store[list2[idx]])
        
        for idx in range(len(list2)):
            if list2[idx] in store and idx + store[list2[idx]] == val:
                result.append(list2[idx])
        
        return result
