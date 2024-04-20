# Time: O(m * n), where m is the length of the given input and n is the average length of every strings in the input list
# Space O(1)
# Problem link: https://leetcode.com/problems/group-anagrams/description/

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = defaultdict(list)

        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord("a")] += 1
            result[tuple(count)].append(s)
        return result.values()
