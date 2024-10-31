# Problem link: https://leetcode.com/problems/design-a-number-container-system/description/
# Time: O(log n)
# Space: O(n)
from sortedcontainers import SortedSet

class NumberContainers:

    def __init__(self):
        self.index_mapping = {}
        self.mapping = defaultdict(SortedSet)

    def change(self, index: int, number: int) -> None:
        if index in self.index_mapping:
            num = self.index_mapping[index]
            self.mapping[num].remove(index)
        
        self.index_mapping[index] = number
        self.mapping[number].add(index)

    def find(self, number: int) -> int:
        if self.mapping[number]:
            return self.mapping[number][0]
        return -1
