# Problem link: https://leetcode.com/problems/reduce-array-size-to-the-half/description/
# Time: O(n log n)
# Space: O(n)
class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        result, idx, size = 0, 0, len(arr)
        store = sorted(list(Counter(arr).values()), reverse = True)

        while size > len(arr) // 2:
            size -= store[idx]
            idx, result = idx + 1, result + 1
        
        return result
