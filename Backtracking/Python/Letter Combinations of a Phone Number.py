# Problem link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
# Time: O(n * 4 ^ n)
# Space: O(n)
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        store = {'2' : 'abc', '3' : 'def', '4' : 'ghi', 
                '5' : 'jkl', '6' : 'mno', '7' : 'pqrs', 
                '8' : 'tuv', '9' : 'wxyz'}

        def backtrack(i, curr):
            if i == len(digits):
                result.append(curr)
                return
            
            for c in store[digits[i]]:
                backtrack(i + 1, curr + c)
        
        result = []
        if digits:
            backtrack(0, '')
            
        return result
