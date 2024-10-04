// Problem link: https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/description
// Time: O(n * log n)
// Space: O(n)
class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int prev = skill[0] + skill[skill.length - 1], left = 0, right = skill.length - 1;
        long result = 0;

        while(left < right) {
            if(prev != skill[left] + skill[right]) {
                return -1;
            }

            result += skill[left++] * skill[right--];
        }

        return result;
    }
}
