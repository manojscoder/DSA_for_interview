# Problem link: https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/description
# Time: O(n * log n)
# Space: O(n)
class Solution:
    def dividePlayers(self, skill: List[int]) -> int:
        skill.sort()
        target, result, left, right = skill[0] + skill[-1], 0, 0, len(skill) - 1

        while left < right:
            if target != skill[left] + skill[right]:
                return -1
            
            result += skill[left] * skill[right]
            left, right = left + 1, right - 1
        
        return result
