# Problem link: https://leetcode.com/problems/xor-queries-of-a-subarray/description
# Time: O(n)
# Space: O(n)
class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        store, result = [0], []
        
        for num in arr:
            store.append(store[-1] ^ num)

        for x, y in queries:
            result.append(store[y + 1] ^ store[x])
        
        return result
