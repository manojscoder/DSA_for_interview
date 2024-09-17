# Problem link: https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
# Time: O(M + N)
# Space: O(M + N)
class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        store = Counter(s1.split() + s2.split())
        result = []

        for key, val in store.items():
            if val == 1:
                result.append(key)
        
        return result
