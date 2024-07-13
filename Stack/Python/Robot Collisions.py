# Problem link: https://leetcode.com/problems/robot-collisions/description/
# Time: O(n * log n)
# Space: O(n)
class Solution:
    def survivedRobotsHealths(self, positions: List[int], healths: List[int], directions: str) -> List[int]:
        idxMap = {pos: idx for idx, pos in enumerate(positions)}
        stack = []

        for pos in sorted(positions):
            pstIdx = idxMap[pos]

            if directions[pstIdx] == 'R':
                stack.append(pstIdx)
            else:
                while stack and healths[pstIdx]:
                    popIdx = stack.pop()
                    if healths[pstIdx] > healths[popIdx]:
                        healths[pstIdx] -= 1
                        healths[popIdx] = 0
                    elif healths[pstIdx] < healths[popIdx]:
                        healths[pstIdx] = 0
                        healths[popIdx] -= 1
                        stack.append(popIdx)
                    else:
                        healths[pstIdx] = healths[popIdx] = 0
        
        return [health for health in healths if health != 0]
