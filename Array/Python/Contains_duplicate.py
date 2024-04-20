# Time: O(n)
# Space: O(n)
# Problem link: https://leetcode.com/problems/contains-duplicate/description/
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        store = set()

        for i in nums:
            if i in store:
                return True
            store.add(i)
        return False
