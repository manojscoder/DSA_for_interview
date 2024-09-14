# Problem link: https://leetcode.com/problems/string-compression/description/
# Time: O(n)
# Space: O(1)
class Solution:
    def compress(self, chars: List[str]) -> int:
        index, count = 0, 1

        for idx in range(1, len(chars) + 1):
            if idx == len(chars) or chars[idx] != chars[idx - 1]:
                chars[index], index = chars[idx - 1], index + 1
                
                if count > 1:
                    for char in str(count):
                        chars[index], index = char, index + 1

                count = 0

            count += 1

        return index
