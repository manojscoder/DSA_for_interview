# Problem link: https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/description
# Time: O(n * m)
# space: O(n * m)
class Solution:
    def maxEqualRowsAfterFlips(self, matrix: List[List[int]]) -> int:
        store = defaultdict(int)

        for row in matrix:
            key = str(row)

            if row[0]:
                key = str([0 if num else 1 for num in row])
            
            store[key] += 1
        
        return max(store.values())
