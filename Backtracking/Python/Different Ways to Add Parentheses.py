# Problem link: https://leetcode.com/problems/different-ways-to-add-parentheses/description
# Time: O(n * 2 ^ n)
# Space: O(2 ^ n)
class Solution:
    operation = {'+' : lambda x, y : x + y,
                 '-' : lambda x, y : x - y,
                 '*' : lambda x, y : x * y}

    def diffWaysToCompute(self, expression: str) -> List[int]:
        result = []

        for idx in range(len(expression)):
            if expression[idx] in self.operation:
                left = self.diffWaysToCompute(expression[:idx])
                right = self.diffWaysToCompute(expression[idx + 1:])

                for n1 in left:
                    for n2 in right:
                        result.append(self.operation[expression[idx]](n1, n2))
        
        return result if result else [int(expression)]
