# Problem link: https://leetcode.com/problems/most-beautiful-item-for-each-query/description
# Time: O(n log n)
# Space: O(n)
class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        items.sort()
        store, maxBeauty, result = [], items[0][1], []

        for price, beauty in items:
            maxBeauty = max(maxBeauty, beauty)
            store.append(maxBeauty)
        
        for query in queries:
            left, right, best = 0, len(items) - 1, 0

            while left <= right:
                mid = (left + right) // 2

                if items[mid][0] <= query:
                    best = store[mid]
                    left = mid + 1
                else:
                    right = mid - 1
        
            result.append(best)
        
        return result
