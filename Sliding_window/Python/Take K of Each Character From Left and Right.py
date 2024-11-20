# Problem link: https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/description/
# Time: O(n)
# Space: O(1)
class Solution:
    def takeCharacters(self, s: str, k: int) -> int:
        right = len(s) - 1
        store = [0] * 3

        while not self.valid(store, k):
            if right == -1:
                return -1

            store[ord(s[right]) - ord('a')] += 1
            right -= 1
        
        result = len(s) - right - 1
        right += 1

        for left in range(len(s)):
            store[ord(s[left]) - ord('a')] += 1

            while right < len(s) and self.valid(store, k):
                store[ord(s[right]) - ord('a')] -= 1
                right += 1
                
            if not self.valid(store, k):
                right -= 1
                store[ord(s[right]) - ord('a')] += 1
            
            result = min(result, left + 1 + len(s) - right)       

        return result

    def valid(self, store, k):
        return store[0] >= k and store[1] >= k and store[2] >= k
