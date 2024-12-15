# Probem link: https://leetcode.com/problems/maximum-average-pass-ratio/description/
# Time: O(n log n)
# Space: O(n)
class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extraStudents: int) -> float:
        store = []

        for ps, stu in classes:
            avg = ps / stu
            inc = (ps + 1) / (stu + 1) - avg
            store.append((-inc, ps, stu))
        
        heapify(store)

        for _ in range(extraStudents):
            _, ps, stu = heappop(store)
            avg = (ps + 1) / (stu + 1)
            newInc = (ps + 2) / (stu + 2) - avg
            heappush(store, (-newInc, ps + 1, stu + 1))
        
        return sum(ps / stu for _, ps, stu in store) / len(classes)
