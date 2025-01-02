# Problem link: https://leetcode.com/problems/count-vowel-strings-in-ranges/description
# Time: O(m + n)
# Space: O(m)
class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        prefix, vowels, result = [0], ['a', 'e', 'i', 'o', 'u'], []

        for word in words:
            prefix.append(prefix[-1])
            if word[0] in vowels and word[-1] in vowels:
                prefix[-1] += 1
                
        for start, end in queries:
            result.append(prefix[end + 1] - prefix[start])
        
        return result
