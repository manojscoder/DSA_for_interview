# Problem link: https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements
# Time: O(n log n)
# Space: O(n)
class Solution:
    def findScore(self, nums: List[int]) -> int:
        store = [(val, index) for index, val in enumerate(nums)]
        heapify(store)
        marked, result = set(), 0

        while store:
            while store and store[0][1] in marked:
                heappop(store)
                
            if store:
                result += store[0][0]
                marked.add(store[0][1])
                marked.add(store[0][1] - 1)
                marked.add(store[0][1] + 1)
                heappop(store)
        
        return result
