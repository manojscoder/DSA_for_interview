# Problem link: https://leetcode.com/problems/shifting-letters-ii/description
# Time: O(n + m)
# Space: O(n)
class Solution:
    def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
        prefix = [0] * (len(s) + 1)
        store = [ord(char) - ord('a') for char in s]

        for start, end, direc in shifts:
            prefix[end + 1] += 1 if direc else -1
            prefix[start] += -1 if direc else 1
        
        total = prefix[-1]

        for index in range(len(s) - 1, -1, -1):
            store[index] = ((store[index] + total) + 26) % 26
            total += prefix[index]
        
        return "".join([chr(val + ord('a')) for val in store])
