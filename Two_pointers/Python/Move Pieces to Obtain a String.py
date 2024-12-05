# Problem link: https://leetcode.com/problems/move-pieces-to-obtain-a-string/description
# Time: O(n)
# Space: O(1)
class Solution:
    def canChange(self, start: str, target: str) -> bool:
        startIdx = targetIdx = 0
        size = len(start)

        while startIdx < size or targetIdx < size:

            while startIdx < size and start[startIdx] == '_':
                startIdx += 1
            
            while targetIdx < size and target[targetIdx] == '_':
                targetIdx += 1
            
            if startIdx == size or targetIdx == size:
                return startIdx == size and targetIdx == size
            
            if (start[startIdx] != target[targetIdx]) or (start[startIdx] == 'L' and startIdx < targetIdx) or (start[startIdx] == 'R' and startIdx > targetIdx):
                return False
            
            startIdx, targetIdx = startIdx + 1, targetIdx + 1
            
        return True
